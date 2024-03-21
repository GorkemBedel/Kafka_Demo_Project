package com.KafkaProject.Kafka.Demo.Project.controller;

import com.KafkaProject.Kafka.Demo.Project.entity.CarEntity;
import com.KafkaProject.Kafka.Demo.Project.entity.FruitEntity;
import com.KafkaProject.Kafka.Demo.Project.kafka.KafkaJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sendJson")
public class JsonMessageController {

    private KafkaJsonProducer kafkaJsonProducer;

    public JsonMessageController(KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    @PostMapping("/publish/Car/{topic}")
    public ResponseEntity<String> publishJsonCar(@PathVariable String topic, @RequestBody CarEntity car){
        kafkaJsonProducer.sendMessageCar(topic,car);
        return ResponseEntity.ok(String.format("Json message is sent to %s topic.",topic));
    }

    @PostMapping("/publish/Fruit/{topic}")
    public ResponseEntity<String> publishJsonFruit(@PathVariable String topic, @RequestBody FruitEntity fruit){
        kafkaJsonProducer.sendMessageFruit(topic,fruit);
        return ResponseEntity.ok(String.format("Json message is sent to %s topic.",topic));
    }
}
