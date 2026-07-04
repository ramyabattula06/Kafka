package com.KafkaOrderSystem.controller;

import org.springframework.web.bind.annotation.*;

import com.KafkaOrderSystem.model.OrderDTO;
import com.KafkaOrderSystem.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderService service;

	public OrderController(OrderService service) {
		this.service = service;
		
	}

	@PostMapping
	public String create(@RequestBody OrderDTO dto) {
		service.createOrder(dto);
		return "Order sent to Kafka!";
	}
}
