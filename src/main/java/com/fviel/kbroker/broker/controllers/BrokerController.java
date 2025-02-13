package com.fviel.kbroker.broker.controllers;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/broker")
public class BrokerController {
    private final KafkaTemplate<String, String> kafkaTemplate;



    public BrokerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    
    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        kafkaTemplate.send("fviel-topic", message);
        return "Message sent for topic 'fviel-topic': " + message;
    }
}