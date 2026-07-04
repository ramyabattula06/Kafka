package com.KafkaOrderSystem.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.KafkaOrderSystem.model.OrderEntity;
import com.KafkaOrderSystem.model.OrderEvent;
import com.KafkaOrderSystem.repository.OrderRepository;

@Service
public class OrderConsumer {

    private final OrderRepository repo;

    public OrderConsumer(OrderRepository repo) {
        this.repo = repo;
    }

    @KafkaListener(topics = "order-topic", groupId = "order-group")
    public void consume(OrderEvent event) {

        if ("FAIL".equals(event.getProduct())) {
            throw new RuntimeException("Simulated failure");
        }

        OrderEntity entity = new OrderEntity();
        entity.setOrderId(event.getOrderId());
        entity.setProduct(event.getProduct());
        entity.setQuantity(event.getQuantity());
        entity.setPrice(event.getPrice());

        repo.save(entity);
    }
}
