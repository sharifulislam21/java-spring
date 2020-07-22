package com.shari.springjunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shari.springjunit.business.ItemService;
import com.shari.springjunit.model.Item;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/item")
	public Item showItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		return itemService.retrieveItem();
	}
	
	@GetMapping("/item-from-database")
	public List<Item> itemFromDatabase() {
		return itemService.retrieveAllItems();
		// http://localhost:8080/h2-console
	}
}

/*
 * (If you are using JUnit 5) In the next lecture, You do NOT need to add
 * 
 * @RunWith(SpringRunner.class) on top of
 * 
 * @WebMvcTest(HelloWorldController.class)
 * 
 * 
 * 
 * JUnit 4 Code
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @WebMvcTest(HelloWorldController.class)
 * 
 * 
 * 
 * JUnit 5 Code
 * 
 * @WebMvcTest(HelloWorldController.class)
 */
