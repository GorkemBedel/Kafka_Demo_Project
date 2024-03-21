package com.KafkaProject.Kafka.Demo.Project.controller;

import com.KafkaProject.Kafka.Demo.Project.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/send")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    @PostMapping("/publish/{topic}")
    public ResponseEntity<String> publish(@PathVariable String topic, @RequestParam("message") String message){
        kafkaProducer.sendMessage(topic, message);
        return ResponseEntity.ok(String.format("Message sent to the %s topic", topic));
    }



}
