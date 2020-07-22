package com.shari.springjunit.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/*when we want to use particular configurations for the specific tests, to be fetched from that particular
property file. We will be creating one inside src/test/resources folder.
Whatever configuration we make inside it will be overriden.*/

@SpringBootTest
@TestPropertySource(locations = {"classpath:test-configuration.properties"})
class ItemControllerIntegrationTest2 {

	@Test
	public void contextLoadsTest() throws JSONException {
		
	}

}
