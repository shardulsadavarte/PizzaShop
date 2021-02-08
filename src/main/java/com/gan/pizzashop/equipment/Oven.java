package com.gan.pizzashop.equipment;

import com.gan.pizzashop.data.Order;

public class Oven implements BakingEquipment{

	private String bakeTime;
	
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
			System.out.println("Broken oven, please repair Oven !");
			e.printStackTrace();			
		}		
		
	}	

}
