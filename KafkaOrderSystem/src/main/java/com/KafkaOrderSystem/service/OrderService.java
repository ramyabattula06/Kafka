package com.KafkaOrderSystem.service;

import org.springframework.stereotype.Service;

import com.KafkaOrderSystem.model.OrderDTO;
import com.KafkaOrderSystem.model.OrderEvent;
import com.KafkaOrderSystem.producer.OrderProducer;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderProducer producer;

    public OrderService(OrderProducer producer) {
        this.producer = producer;
    }

    public void createOrder(OrderDTO dto) {

        if (dto.getQuantity() <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }

        String orderId = UUID.randomUUID().toString();

        OrderEvent event = OrderEvent.builder()
                .orderId(orderId)
                .product(dto.getProduct())
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .build();

        producer.send(event);
    }
}
