package com.gan.pizzashop.controller;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.gan.pizzashop.service.OrderManagerService;
import com.gan.pizzashop.util.PizzashopConstants;

@Controller
public class OrderController {
	
	@Autowired
	@Qualifier("ingredientsMap")
	HashMap<String, Integer> ingredientsMap;
	
	@Autowired
	@Qualifier("orderStatus")
	HashMap<String, String> orderStatus;
	
	@Autowired
	IngredientsInventoryService ingredientsInventoryService;
	
	@Autowired
	OrderManagerService orderManagerService;	
	
	
	@GetMapping("/orderHome") 
	public String orderHome(Model model, PizzaOrder pizzaOrder) {
		
		model.addAttribute("ingardientsMap", ingredientsMap);	
		
        return "orderPage";		
	}
	
	
	@PostMapping("/placePizzaOrder")
	public String placePizzaOrder(PizzaOrder pizzaOrder) {
		
		boolean sufficientInventory =  ingredientsInventoryService.checkAndUpdatePizzaInventory(pizzaOrder);
			
		Order uniqueOrder = orderManagerService.createUniqueOrder(pizzaOrder);
		
		if(sufficientInventory) {
			orderManagerService.placeOrder(uniqueOrder);
			orderStatus.put(uniqueOrder.getOrderId(), PizzashopConstants.ORDER_PLACED);
		} else {
			orderStatus.put(uniqueOrder.getOrderId(), PizzashopConstants.ORDER_NOT_PLACED);
		}
					
		return "redirect:/orderStatus?orderId="+uniqueOrder.getOrderId();		
	}
	
	
	@GetMapping("/orderStatus")
	public String orderStatus(@RequestParam(value = "orderId") String orderId, Model model) {
		
		model.addAttribute("orderName", orderId);
		model.addAttribute("orderStatus", (orderStatus.get(orderId) != null ? orderStatus.get(orderId) : PizzashopConstants.ORDER_NOT_FOUND));
		
		return "orderStatusPage";		
	}
	
	
	@GetMapping("/allOrderStatus")
	public String allOrderStatus(Model model) {
		
		model.addAttribute("allOrders", orderStatus);
		
		return "allOrderStatusPage";		
	}

}
