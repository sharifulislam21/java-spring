package com.shari.springjunit.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.shari.springjunit.business.ItemService;
import com.shari.springjunit.data.DataService;
import com.shari.springjunit.data.ItemRepository;
import com.shari.springjunit.model.Item;


/*
 * If you are using JUnit 5
 * @ExtendWith(MockitoExtension.class)
 * instead of @RunWith(MockitoJUnitRunner.class)
 *
 **/

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {
	
	@InjectMocks
	ItemService itemService;
	
	@Mock
	ItemRepository itemRepository;
	
	@Test
	public void retrieveAllItemsFromService() {

		when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(2, "Bat", 15, 50),
				new Item(3, "Bells", 30, 10)));
		List<Item> items = itemService.retrieveAllItems();
		assertEquals(750, items.get(0).getValue());
		assertEquals(300, items.get(1).getValue());
	}

}
