package com.shari.springjunit.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shari.springjunit.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
