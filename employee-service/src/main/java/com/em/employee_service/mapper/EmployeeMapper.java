package com.em.employee_service.mapper;

import com.em.employee_service.dto.EmployeeRequestDTO;
import com.em.employee_service.dto.EmployeeResponseDTO;
import com.em.employee_service.entity.Employee;

import java.time.LocalDate;

public class EmployeeMapper {
    public static EmployeeResponseDTO toEmployeeResponseDTO(Employee employee) {
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        employeeResponseDTO.setId(employee.getId().toString());
        employeeResponseDTO.setName(employee.getName());
        employeeResponseDTO.setEmail(employee.getEmail());
        employeeResponseDTO.setDepartment(employee.getDepartment());
        employeeResponseDTO.setDateOfBirth(employee.getDateOfBirth().toString());
        employeeResponseDTO.setDesignation(employee.getDesignation());
        return employeeResponseDTO;
    }

    public static Employee toEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = new Employee();
        employee.setName(employeeRequestDTO.getName());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setAddress(employeeRequestDTO.getAddress());
        employee.setDepartment(employeeRequestDTO.getDepartment());
        employee.setDateOfBirth(LocalDate.parse(employeeRequestDTO.getDateOfBirth()));
        employee.setRegisterDate(LocalDate.parse(employeeRequestDTO.getRegisterDate()));
        employee.setDesignation(employeeRequestDTO.getDesignation());
        return employee;
    }
}
