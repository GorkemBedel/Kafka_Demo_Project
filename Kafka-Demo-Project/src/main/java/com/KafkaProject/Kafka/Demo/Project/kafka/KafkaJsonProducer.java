package com.KafkaProject.Kafka.Demo.Project.kafka;

import com.KafkaProject.Kafka.Demo.Project.entity.CarEntity;
import com.KafkaProject.Kafka.Demo.Project.entity.FruitEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);

    private KafkaTemplate<String, CarEntity> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, CarEntity> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    //TO STRINGTE HATA OLABİLİR
    public void sendMessageCar(String topic, CarEntity car){
        LOGGER.info(String.format("Message is sent : %s", car.toString()));

        Message<CarEntity> message = MessageBuilder
                .withPayload(car)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
        kafkaTemplate.send(message);
    }

    public void sendMessageFruit(String topic, FruitEntity fruit){
        LOGGER.info(String.format("Message is sent : %s", fruit.toString()));

        Message<FruitEntity> message = MessageBuilder
                .withPayload(fruit)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
        kafkaTemplate.send(message);
    }
}
