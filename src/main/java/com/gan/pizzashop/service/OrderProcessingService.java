package com.gan.pizzashop.service;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gan.pizzashop.data.Order;
import com.gan.pizzashop.equipment.Oven;
import com.gan.pizzashop.util.PizzashopConstants;

@Service
public class OrderProcessingService implements Runnable {
	
	private Thread thread;
	
	OrderProcessingService(){
		this.thread = new Thread(this);
        this.thread.start();
	}

	@Autowired
	@Qualifier("startedOvens")
	BlockingQueue<Oven> startedOvens;

	@Autowired
	@Qualifier("orderStatus")
	HashMap<String, String> orderStatus;

	@Autowired
	@Qualifier("orderQueue")
	BlockingQueue<Order> orderQueue;
	
	@Autowired
	BakingService bakingService;
	
	@Override
	public void run() {
		
		while (true) {
			
			if (null != orderQueue && !orderQueue.isEmpty()) {
	
				Order order = orderQueue.peek();
				Oven oven = startedOvens.poll();
	
				if (null == oven) {
					orderStatus.put(order.getOrderId(), PizzashopConstants.WAITING_FOR_OVEN);
					
				} else {				
						new Thread( new Runnable() {
							public void run() {							
								bakingService.bake(order, oven);
							}						
						}).start();					
					
					orderQueue.poll();
				}
			}		
		}		
	}
}
