package com.gan.pizzashop.util;

public interface PizzashopConstants {

	public static final String INGREDIENTS_FILE = "static/ingredients.csv";

	public static final String ORDER_PLACED = "Order is placed !";
	public static final String ORDER_NOT_PLACED = "Order can not be placed due to insufficient inventory. Please place new order !";
	public static final String ORDER_NOT_FOUND = "No order found with this id !";
	public static final String WAITING_FOR_OVEN = "Order is waiting for the oven !";
	public static final String ORDER_BAKING = "Order is baking inside the oven !";
	public static final String ORDER_READY = "Order is ready !";
	
	public static final String WARN_INSUFFICIENT_INVENTORY = "Insufficient inventory, please add inventory !";
	
	public static final String ERROR_BROKEN_OVEN = "Broken oven, please repair Oven !";
	public static final String ERROR_INGREDIENTS = "Error loading ingredients file !";

}
