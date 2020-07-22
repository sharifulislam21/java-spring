package com.shari.springjunit.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

class JsonPathTest {

	@Test
	void test() {
		String response = "{\"id\": 10001, \"name\": \"Pencil\", \"quantity\": 5}," + 
				"	{\"id\": 10002, \"name\": \"Pen\", \"quantity\": 10}," + 
				"	{\"id\": 10003, \"name\": \"Eraser\", \"quantity\": 15}";
		
		DocumentContext context =  JsonPath.parse(response);
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		List<Integer> ids = context.read("$..id");
		assertThat(ids).containsExactly(10001, 10002);	
		System.out.println(ids.toString());
	}

}
