package com.gan.pizzashop.config;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderStatusConfig {
	
	@Bean(name = "orderStatus")
	public HashMap<String, String> orderStatusMap(){
		
		return new HashMap<String, String>();
	}

}
