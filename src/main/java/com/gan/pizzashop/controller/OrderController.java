package com.gan.pizzashop.controller;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gan.pizzashop.data.Order;
import com.gan.pizzashop.data.PizzaOrder;
import com.gan.pizzashop.service.IngredientsInventoryService;

@Controller
public class OrderController {
	
	@Autowired
	@Qualifier("ingredientsMap")
	HashMap<String, Integer> ingredientsMap;
	
	@Autowired
	@Qualifier("orderQueue")
	BlockingQueue<Order> orderQueue;
	
	@Autowired
	@Qualifier("orderStatus")
	HashMap<String, String> orderStatus;
	
	@Autowired
	IngredientsInventoryService ingredientsInventoryService;
	
	
	@GetMapping("/orderHome")
	public String orderHome(Model model, PizzaOrder pizzaOrder) {
		
		System.out.println("Inside loadOrderPage() ");
		
		model.addAttribute("ingardientsMap", ingredientsMap);
		
        return "orderPage";		
	}
	
	
	@PostMapping("/placePizzaOrder")
	public String placePizzaOrder(Model model, PizzaOrder pizzaOrder) {
		
		orderQueue.add(pizzaOrder);
		orderStatus.put(pizzaOrder.getOrderId(), "Your order is placed !");
		
		ingredientsInventoryService.updateInventory((PizzaOrder) pizzaOrder);
						
		model.addAttribute("orderName", pizzaOrder.getOrderId());
		model.addAttribute("orderStatus", orderStatus.get(pizzaOrder.getOrderId()));
		
		return "orderStatusPage";		
	}
	
	
	@GetMapping("/orderStatus")
	public String orderStatus(@RequestParam(value = "orderId") String orderId, Model model) {
		
		System.out.println("Inside loadOrderStatusPage() ");
		
		model.addAttribute("orderName", orderId);
		model.addAttribute("orderStatus", (orderStatus.get(orderId) != null ? orderStatus.get(orderId) : "No Order Found with this Name"));
		
		return "orderStatusPage";		
	}
	
	@GetMapping("/allOrderStatus")
	public String allOrderStatus(Model model) {
		
		System.out.println("Inside loadAllOrderStatusPage() ");
		
		model.addAttribute("allOrders", orderStatus);
		
		return "allOrderStatusPage";		
	}

}
