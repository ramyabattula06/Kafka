package com.KafkaOrderSystem.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.KafkaOrderSystem.model.OrderEvent;

@Service
public class DLTConsumer {

    @KafkaListener(topics = "order-topic.DLT", groupId = "dlt-group")
    public void listenDLT(OrderEvent event) {
        System.out.println("Message in DLT: " + event);
    }
}