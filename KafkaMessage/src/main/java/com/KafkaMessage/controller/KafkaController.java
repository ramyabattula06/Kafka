package com.KafkaMessage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.KafkaMessage.Service.KafkaProducerService;



@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducerService producerService;

    public KafkaController(
            KafkaProducerService producerService) {

        this.producerService = producerService;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(
            @RequestParam String message) {

        producerService.sendMessage(
                "my-topic",
                message);

        return ResponseEntity.ok(
                "Message published successfully");
    }
}
