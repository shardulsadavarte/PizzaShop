package com.gan.pizzashop.service;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.gan.pizzashop.data.Order;
import com.gan.pizzashop.equipment.Oven;

@Service
@Scope("prototype")
public class BakingService {
	
	@Autowired
	@Qualifier("startedOvens")
	BlockingQueue<Oven> startedOvens;

	@Autowired
	@Qualifier("orderStatus")
	HashMap<String, String> orderStatus; 
	
	public void bake(Order order, Oven oven) {
		
		orderStatus.put(order.getOrderId(), "Your pizza is baking inside the oven !");
		oven.bake(order);
		orderStatus.put(order.getOrderId(), "Your pizza is ready !");
		startedOvens.add(oven);
	}

}
