package com.gan.pizzashop.data;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class PizzaOrder extends Order {
		
	@NonNull
	private Integer cheese;
	
	@NonNull
	private Integer chicken;
	
	@NonNull
	private Integer jalapeno;
	
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
	public Integer getJalapeno() {
		return jalapeno;
	}
	public void setJalapeno(Integer jalapeno) {
		this.jalapeno = jalapeno;
	}
		

}
