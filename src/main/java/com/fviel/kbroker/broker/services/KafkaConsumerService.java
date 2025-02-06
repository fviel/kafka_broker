package com.fviel.kbroker.broker.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "fviel-topic", groupId = "fviel-group")
    public void listen(ConsumerRecord<String, String> record){
        System.out.println("### Received: " + record.value());
    }

    @KafkaListener(topics = "fviel-topic", groupId = "fviel-group")
    public void listen(String message) {
        System.out.println("### Received: " + message);
    }
}
