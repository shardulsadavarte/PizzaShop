package com.gan.pizzashop.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gan.pizzashop.data.PizzaOrder;

@Service
public class IngredientsInventoryService {

	@Autowired
	@Qualifier("ingredientsMap")
	HashMap<String, Integer> ingredientsMap;
	
	public void updateInventory(PizzaOrder pizzaOrder) {
		
		int remainingCheese = ingredientsMap.get("cheese") - pizzaOrder.getCheese();
		int remainingChicken = ingredientsMap.get("chicken") - pizzaOrder.getChicken();
		int remainingMarinara = ingredientsMap.get("marinara") -  pizzaOrder.getMarinara();
		
		ingredientsMap.put("cheese", remainingCheese);
		ingredientsMap.put("chicken", remainingChicken);
		ingredientsMap.put("marinara", remainingMarinara);
		
	}	

}
