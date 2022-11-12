package com.example.kafkasample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProperties {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Value(value = "${kafka.groupId}")
    private String groupId;

    @Value(value = "${kafka.topic}")
    private String topic;

    public String getBootstrapAddress() {
        return bootstrapAddress;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getTopic() {
        return topic;
    }
}
