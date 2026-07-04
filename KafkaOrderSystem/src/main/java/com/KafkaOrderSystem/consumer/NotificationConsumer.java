package com.KafkaOrderSystem.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.KafkaOrderSystem.model.OrderEvent;

@Service
public class NotificationConsumer {

	@KafkaListener(topics = "order-topic", groupId = "notification-group")
	public void sendNotification(OrderEvent event) {
		System.out.println("Notification sent for Order: " + event.getOrderId());
	}
}
