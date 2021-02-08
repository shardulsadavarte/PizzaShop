package com.gan.pizzashop.data;

import org.springframework.stereotype.Component;

@Component
public class Order {

	private String orderId;
		
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderId() {
		return orderId;
	}

}
