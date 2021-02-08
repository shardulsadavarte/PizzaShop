package com.gan.pizzashop.config;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AvailableIngredientsConfig {
	
	@Bean(name = "ingredientsMap")
	public HashMap<String, Integer> loadAvailableIngredients() {
		
		HashMap<String, Integer> ingredientsMap = new HashMap<String, Integer>();
		ingredientsMap.put("cheese", 3);
		ingredientsMap.put("chicken", 3);
		ingredientsMap.put("marinara", 3);
		
		return ingredientsMap;
	}
	

}
