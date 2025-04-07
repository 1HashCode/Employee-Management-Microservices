package com.em.hr_analytics_service.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import employee.events.EmployeeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "employee",groupId = "hr-analytics-service")
    public void consumeEvent(byte[]event){
        EmployeeEvent employeeEvent= null;
        try {
            employeeEvent = EmployeeEvent.parseFrom(event);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
        //business logic
        log.info("Received event from Kafka: {}", employeeEvent);
    }
}
