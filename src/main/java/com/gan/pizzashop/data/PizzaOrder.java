package com.gan.pizzashop.data;

import org.springframework.stereotype.Component;

@Component
public class PizzaOrder extends Order {
		
	private Integer cheese;
	private Integer chicken;
	private Integer marinara;
	
	public Integer getCheese() {
		return cheese;
	}
	public void setCheese(Integer cheese) {
		this.cheese = cheese;
	}
	public Integer getChicken() {
		return chicken;
	}
	public void setChicken(Integer chicken) {
		this.chicken = chicken;
	}
	public Integer getMarinara() {
		return marinara;
	}
	public void setMarinara(Integer marinara) {
		this.marinara = marinara;
	}
	
	

}
