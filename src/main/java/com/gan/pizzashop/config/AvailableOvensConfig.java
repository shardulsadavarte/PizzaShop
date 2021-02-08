package com.gan.pizzashop.config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gan.pizzashop.equipment.Oven;

@Configuration
public class AvailableOvensConfig {
	
	@Value("${baking.ovens.number}")
	private String availableOvens;
	
	@Value("${baking.ovens.baketime}")
	private String bakeTime;
	
	@Bean(name = "startedOvens")
	public BlockingQueue<Oven> startAvailableOvens(){
		
		BlockingQueue<Oven> startedOvens = new LinkedBlockingQueue<Oven>(Integer.parseInt(availableOvens.trim()));
		
		for(int i=0; i<Integer.parseInt(availableOvens); i++) {
			startedOvens.add(new Oven(bakeTime.trim()));
		}
		return startedOvens;
	}

}
