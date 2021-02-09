package com.gan.pizzashop.service;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gan.pizzashop.data.Order;

@Service
public class OrderManagerService {
	
	@Autowired
	@Qualifier("orderQueue")
	BlockingQueue<Order> orderQueue;	

	public void placeOrder(Order order) {		
		
		orderQueue.add(order);		
	}

	
	public Order createUniqueOrder(Order order) {
		
		String orderId = order.getOrderId()+"@"+(new Date()).getTime();
		order.setOrderId(orderId);
		return order;
	}

}
