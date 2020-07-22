package com.shari.springjunit.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class AssertJTest {

	@Test
	void test() {
		List<Integer> numbers = Arrays.asList(12,23,34);
		
		assertThat(numbers).hasSize(3)
							.contains(12)
							.allMatch(x -> x > 10)
							.allMatch(x -> x < 100)
							.noneMatch(x -> x < 0);
		
		assertThat("").isEmpty();
		assertThat("ABCDE").contains("BC")
							.startsWith("A")
							.endsWith("E");
	}

}
