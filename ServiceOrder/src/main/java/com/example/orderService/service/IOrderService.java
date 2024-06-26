package com.example.orderService.service;


import java.util.List;
import java.util.Optional;

import com.example.orderService.model.Order;



public interface IOrderService {
	 List<Order> getAllOrders();
	    Optional<Order> getOrderById(Long id);
	    Order createOrder(Order order);
	    Optional<Order> updateOrder(Long id, Order order);
	    void deleteOrder(Long id);
}
