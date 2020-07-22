package com.shari.springjunit.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shari.springjunit.data.ItemRepository;
import com.shari.springjunit.model.Item;

@Component
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	public Item retrieveItem() {
		
		return new Item(2, "Bat", 15, 500);
	}
	
	public List<Item> retrieveAllItems(){
		
		List<Item> items = itemRepository.findAll();
		
		for(Item item : items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		return items;
	}

}
