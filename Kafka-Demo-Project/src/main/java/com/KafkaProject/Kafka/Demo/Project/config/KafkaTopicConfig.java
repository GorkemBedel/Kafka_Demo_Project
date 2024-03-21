package com.KafkaProject.Kafka.Demo.Project.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topicCar(){
        return TopicBuilder.name("Car")
                .partitions(5)
                .build();
    }

    @Bean
    public NewTopic topicJsonCar() {
        return TopicBuilder.name("CarJson")
                .partitions(5)
                .build();
    }

    @Bean
    public NewTopic topicFruit() {
        return TopicBuilder.name("Fruit")
                .partitions(5)
                .build();
    }

    @Bean
    public NewTopic topicJsonFruit() {
        return TopicBuilder.name("FruitJson")
                .partitions(5)
                .build();
    }


}
