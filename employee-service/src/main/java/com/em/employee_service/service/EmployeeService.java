package com.em.employee_service.service;

import com.em.employee_service.dto.EmployeeRequestDTO;
import com.em.employee_service.dto.EmployeeResponseDTO;
import com.em.employee_service.exception.EmailAlreadyExistsException;
import com.em.employee_service.exception.EmployeeNotFoundException;
import com.em.employee_service.grpc.PerformanceServiceGrpcClient;
import com.em.employee_service.kafka.KafkaProducer;
import com.em.employee_service.mapper.EmployeeMapper;
import com.em.employee_service.entity.Employee;
import com.em.employee_service.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;
    private final PerformanceServiceGrpcClient performanceServiceGrpcClient;
    private final KafkaProducer kafkaProducer;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, PerformanceServiceGrpcClient performanceServiceGrpcClient, KafkaProducer kafkaProducer) {
        this.employeeRepository = employeeRepository;
        this.performanceServiceGrpcClient = performanceServiceGrpcClient;
        this.kafkaProducer = kafkaProducer;
    }

    public List<EmployeeResponseDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::toEmployeeResponseDTO).toList();
    }

    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO){
        if(employeeRepository.existsByEmail(employeeRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("Employee with email "+employeeRequestDTO.getEmail()+" already exists");
        }
        Employee employee = EmployeeMapper.toEmployee(employeeRequestDTO);
        employee = employeeRepository.save(employee);

        performanceServiceGrpcClient.createPerformanceAccount(employee.getId().toString(),employee.getName(),employee.getEmail(),employee.getDesignation());

        kafkaProducer.sendEvent(employee);

        return EmployeeMapper.toEmployeeResponseDTO(employee);
    }

    public EmployeeResponseDTO updateEmployee(UUID id,EmployeeRequestDTO employeeRequestDTO){
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee with id "+id+" not found"));

        if(!employeeRequestDTO.getEmail().equals(employee.getEmail()) && employeeRepository.existsByEmail(employeeRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("Employee with email "+employeeRequestDTO.getEmail()+" already exists");
        }

        employee.setName(employeeRequestDTO.getName());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setDepartment(employeeRequestDTO.getDepartment());
        employee.setAddress(employeeRequestDTO.getAddress());
        employee.setDateOfBirth(LocalDate.parse(employeeRequestDTO.getDateOfBirth()));
        employee.setDesignation(employeeRequestDTO.getDesignation());

        Employee updatedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.toEmployeeResponseDTO(updatedEmployee);
    }

    public void deleteEmployee(UUID id){
        log.info("Deleting employee with id {}", id);
        performanceServiceGrpcClient.deletePerformanceAccount(id.toString(),"a","a","a");
        employeeRepository.deleteById(id);
    }

}
