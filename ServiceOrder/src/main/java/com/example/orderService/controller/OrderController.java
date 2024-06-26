package com.example.orderService.controller;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.orderService.model.Order;
import com.example.orderService.service.OrderService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
	  @Autowired
	    private OrderService orderService;

	    // Get all orders
	    @GetMapping
	    public List<Order> getAllOrders() {
	        return orderService.getAllOrders();
	    }

	    // Get order by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
	        Optional<Order> optionalOrder = orderService.getOrderById(id);
	        if (optionalOrder.isPresent()) {
	            return ResponseEntity.ok(optionalOrder.get());
	        }
	        return ResponseEntity.notFound().build();
	    }

	    // Create order
	    @PostMapping
	    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
	        Order createdOrder = orderService.createOrder(order);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
	    }

	    // Update order
	    @PutMapping("/{id}")
	    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
	        Optional<Order> optionalUpdatedOrder = orderService.updateOrder(id, order);
	        if (optionalUpdatedOrder.isPresent()) {
	            return ResponseEntity.ok(optionalUpdatedOrder.get());
	        }
	        return ResponseEntity.notFound().build();
	    }

	    // Delete order
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
	        orderService.deleteOrder(id);
	        return ResponseEntity.noContent().build();
	    }


	}
