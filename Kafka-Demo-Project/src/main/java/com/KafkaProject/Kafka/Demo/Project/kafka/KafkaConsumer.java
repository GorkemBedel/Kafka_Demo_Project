package com.KafkaProject.Kafka.Demo.Project.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private final static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = {"Car","Fruit"}, groupId = "consumerGroup1")
    public void consume(String message){
        LOGGER.info(String.format("Message received : %s", message));

    }
}
