package com.gan.pizzashop.service;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gan.pizzashop.data.Order;
import com.gan.pizzashop.util.PizzashopConstants;

@Service
public class OrderManagerService {
	
	@Autowired
	@Qualifier("orderQueue")
	BlockingQueue<Order> orderQueue;	

	private static final Logger logger = LoggerFactory.getLogger(OrderManagerService.class);
	
	public void placeOrder(Order order) throws Exception  {		
		
		try {
			orderQueue.put(order);
		} catch (InterruptedException e) {
			logger.error(PizzashopConstants.ERROR_ORDERING_SYSTEM,e);
			throw new Exception();
		}		
	}

	
	public Order createUniqueOrder(Order order) {
		
		String orderId = order.getOrderId()+"@"+(new Date()).getTime();
		order.setOrderId(orderId);
		return order;
	}

}
