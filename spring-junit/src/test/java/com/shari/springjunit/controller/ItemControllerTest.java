package com.shari.springjunit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.shari.springjunit.business.ItemService;
import com.shari.springjunit.model.Item;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemService itemService;
	
	@Test
	public void showItemTest() throws Exception {
		
		// Call GET "/hello-world" applicatio/json
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andReturn();
		
		// Verify 
		assertEquals("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}", result.getResponse().getContentAsString());
	}
	
	@Test
	public void showItemFromServiceTest() throws Exception {
		
		when(itemService.retrieveItem()).thenReturn(
				new Item(2, "Bat", 15, 500));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andReturn();
		
		// Verify 
		assertEquals("{\"id\":2,\"name\":\"Bat\",\"price\":15,\"quantity\":500}", result.getResponse().getContentAsString());
	}
	
	@Test
	public void itemFromDatabaseTest() throws Exception {
		
		when(itemService.retrieveAllItems()).thenReturn(
				Arrays.asList(new Item(2, "Bat", 15, 500),
						new Item(3, "Bells", 30, 10))
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-from-database")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:2,name:Bat,price:15,quantity:500},{id:3,name:Bells,price:30,quantity:10}]"))
				.andReturn();
		
		// Verify 
		//assertEquals("[{\"id\":2,\"name\":\"Bat\",\"price\":15,\"quantity\":500}]", result.getResponse().getContentAsString());
		//JSONAssert.assertEquals("[{id:2,name:Bat,price:15,quantity:500},{id:3,name:Bells,price:30,quantity:10}]", result.getResponse().getContentAsString(), false);
	}

}
