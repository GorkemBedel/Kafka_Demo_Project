package com.KafkaProject.Kafka.Demo.Project.kafka;

import com.KafkaProject.Kafka.Demo.Project.entity.CarEntity;
import com.KafkaProject.Kafka.Demo.Project.entity.FruitEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {
    private final static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "CarJson", groupId = "consumerGroup1")
    public void consumeCarJson(CarEntity car){
        LOGGER.info(String.format("Car json message is received : %s",car.toString()));
    }

    @KafkaListener(topics = "FruitJson", groupId = "consumerGroup1")
    public void consumeFruitJson(FruitEntity fruit){
        LOGGER.info(String.format("Fruit json message is received : %s",fruit.toString()));
    }

}
