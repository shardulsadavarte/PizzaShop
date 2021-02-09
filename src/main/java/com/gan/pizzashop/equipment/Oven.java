package com.gan.pizzashop.equipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gan.pizzashop.data.Order;
import com.gan.pizzashop.util.PizzashopConstants;

public class Oven implements BakingEquipment{

	private String bakeTime;
	
	private static final Logger logger = LoggerFactory.getLogger(Oven.class);

	
	public Oven(String bakeTime) {
		this.bakeTime = bakeTime;
	}
	
	@Override
	public void bake(Order order) {		
				
		try {
			//Baking process
			Thread.sleep(Integer.parseInt(bakeTime));
		
			return;
		} catch (Exception e) {
			logger.error(PizzashopConstants.ERROR_BROKEN_OVEN, e);
		}		
		
	}	

}
