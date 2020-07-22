package com.shari.springjunit.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ItemControllerIntegrationTest {

	@Autowired
	private TestRestTemplate resttemplate;
	
	@Test
	public void contextLoadsTest() throws JSONException {
		String actualResponse = this.resttemplate.getForObject("/item-from-database", String.class);
		String expectedResponse = "[{id:10001},{id:10002},{id:10003}]";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

}
