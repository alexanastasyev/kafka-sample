package com.example.kafkasample.controller;

import com.example.kafkasample.config.KafkaProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class MessageController {

    private final KafkaProperties properties;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MessageController(KafkaProperties properties, KafkaTemplate<String, String> kafkaTemplate) {
        this.properties = properties;
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        kafkaTemplate.send(properties.getTopic(), message);
        return "Success";
    }

}
