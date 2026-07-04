package com.KafkaOrderSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.KafkaOrderSystem.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {
}
