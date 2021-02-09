package com.gan.pizzashop.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gan.pizzashop.data.PizzaOrder;
import com.gan.pizzashop.util.PizzashopConstants;

@Service
public class IngredientsInventoryService {

	@Autowired
	@Qualifier("ingredientsMap")
	HashMap<String, Integer> ingredientsMap;
	
	private static final Logger logger = LoggerFactory.getLogger(IngredientsInventoryService.class);

	
	public boolean checkAndUpdatePizzaInventory(PizzaOrder pizzaOrder) {
	
		int remainingCheese = ingredientsMap.get("cheese") - pizzaOrder.getCheese();
		int remainingChicken = ingredientsMap.get("chicken") - pizzaOrder.getChicken();
		int remainingJalapeno = ingredientsMap.get("jalapeno") -  pizzaOrder.getJalapeno();
		
		if((remainingCheese < 0) || (remainingChicken < 0) || (remainingJalapeno < 0)){
			logger.warn(PizzashopConstants.WARN_INSUFFICIENT_INVENTORY);
			// Email Shop Manager
			return false;			
		} else {		
			ingredientsMap.put("cheese", remainingCheese);
			ingredientsMap.put("chicken", remainingChicken);
			ingredientsMap.put("jalapeno", remainingJalapeno);			
			return true;		
		}
	}

}
