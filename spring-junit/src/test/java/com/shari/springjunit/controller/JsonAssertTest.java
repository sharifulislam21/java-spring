package com.shari.springjunit.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {

	String actual = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	void jsonAssertTest_strictTrue() throws JSONException {
		String expect = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expect, actual, true);
	}
	
	@Test
	void jsonAssertTest_strictFalse() throws JSONException {
		String expect = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
		JSONAssert.assertEquals(expect, actual, false);
	}

	@Test
	void jsonAssertTest_withoutEscapeCharacters() throws JSONException {
		String expect = "{id:1,name:Ball,price:10}"; //in case of space we need to add escape characters
		JSONAssert.assertEquals(expect, actual, false);
	}
}
