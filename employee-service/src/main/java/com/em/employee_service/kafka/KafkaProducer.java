package com.em.employee_service.kafka;

import com.em.employee_service.entity.Employee;
import employee.events.EmployeeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(Employee employee){
        EmployeeEvent employeeEvent=EmployeeEvent.newBuilder()
                .setEmployeeId(employee.getId().toString())
                .setName(employee.getName())
                .setEmail(employee.getEmail())
                .setDepartment(employee.getDepartment())
                .setDesignation(employee.getDesignation())
                .setEventType("EMPLOYEE_CREATED")
                .build();

        try{
            kafkaTemplate.send("employee",employeeEvent.toByteArray());
        }
        catch (Exception e){
            log.error("Error while sending event to Kafka",e);
        }
    }

}
