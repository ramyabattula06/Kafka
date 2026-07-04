package com.KafkaOrderSystem.producer;



import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.KafkaOrderSystem.model.OrderEvent;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(OrderEvent event) {
        kafkaTemplate.send("order-topic", event.getOrderId(), event);
    }
}
