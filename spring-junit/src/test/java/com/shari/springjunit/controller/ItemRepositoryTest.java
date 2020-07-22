package com.shari.springjunit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.shari.springjunit.data.ItemRepository;
import com.shari.springjunit.model.Item;

// DataJpaTest is used for testing data/repository level 
@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository repository;
	
	@Test
	public void findAllTest( ) {
		List<Item> items = repository.findAll();
		assertEquals(3, items.size());
	}
}
