package com.KafkaOrderSystem.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.KafkaOrderSystem.model.OrderEvent;

@Service
public class InventoryConsumer {

	@KafkaListener(topics = "order-topic", groupId = "inventory-group")
	public void updateInventory(OrderEvent event) {
		System.out.println("Inventory updated for: " + event.getProduct());
	}
}
