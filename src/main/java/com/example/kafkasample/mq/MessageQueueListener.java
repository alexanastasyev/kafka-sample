package com.example.kafkasample.mq;

import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/application.properties")
public class MessageQueueListener {

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.groupId}")
    public void listen(String message) {
        System.out.println("Received Message: " + message);
    }

}
