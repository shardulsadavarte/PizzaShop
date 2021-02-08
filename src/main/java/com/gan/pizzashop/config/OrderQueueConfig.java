package com.gan.pizzashop.config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gan.pizzashop.data.Order;

@Configuration
public class OrderQueueConfig {
	
	@Bean(name = "orderQueue")
	public BlockingQueue<Order> createPizzaOrderQueue(){
		
		return new LinkedBlockingQueue<Order>(100);
	}	

}
