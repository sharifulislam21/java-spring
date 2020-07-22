package com.shari.springjunit.spike;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class HamcrestTest {

	@Test
	void test() {
		List<Integer> numbers = Arrays.asList(12,23,34);
		
		assertThat(numbers, hasSize(3));
		assertThat(numbers, hasItems(12,45));
		assertThat(numbers, everyItem(greaterThan(10)));
		assertThat(numbers, everyItem(lessThan(100)));
		
		assertThat("", isEmptyString());
		assertThat("ABCDE", containsString("ABC"));
		assertThat("ABCDE", startsWith("A"));
		assertThat("ABCDE", endsWith("E"));
	}

}
