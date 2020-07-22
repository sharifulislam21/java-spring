package com.shari.springjunit.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

@SuppressWarnings("rawtypes")
class ListMockTest {

	List mockList = mock(List.class);

	@Test
	void sizeTest() {
		when(mockList.size()).thenReturn(5);
		assertEquals(5, mockList.size());
	}

	@Test
	void returnDiffValuesTest() {
		when(mockList.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mockList.size());
		assertEquals(10, mockList.size());
	}

	@Test
	void returnWithParamTest() {
		when(mockList.get(0)).thenReturn("Rock It!!!");
		assertEquals("Rock It!!!", mockList.get(0));
		assertEquals(null, mockList.get(1));
	}

	// ArgumentMatcher - anyInt()
	@Test
	void returnWithGenericParamsTest() {
		when(mockList.get(anyInt())).thenReturn("Rock It!!!");
		assertEquals("Rock It!!!", mockList.get(0));
		assertEquals("Rock It!!!", mockList.get(1));
	}

	// Testing specific method is called with a specific value on a mock
	// important in scenarios where valu is never returned back
	@Test
	void verificationBasics() {
		// System Under Test
		String value1 = (String) mockList.get(0);
		String value2 = (String) mockList.get(1);

		// verify
		verify(mockList).get(0);
		verify(mockList, times(2)).get(anyInt());
		verify(mockList, atLeast(1)).get(anyInt());
		verify(mockList, atMost(2)).get(anyInt());
		verify(mockList, never()).get(2);
	}

	@Test
	void argumentCapturing() {
		// System Under Test
		mockList.add("Simple String");

		// verify
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mockList).add(captor.capture());

		assertEquals("Simple String", captor.getValue());
	}

	@Test
	void multipleArgumentCapturing() {
		// System Under Test
		mockList.add("Some String");
		mockList.add("Another String");

		// verify
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mockList, times(2)).add(captor.capture());

		List<String> allValues = captor.getAllValues();
		assertEquals("Some String", allValues.get(0));
		assertEquals("Another String", allValues.get(1));
	}

	@Test
	void mocking() {

		ArrayList arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0)); // null
		System.out.println(arrayListMock.size()); // 0
		arrayListMock.add("Some String");
		arrayListMock.add("Another String");
		System.out.println(arrayListMock.size()); // 0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size()); // 5
	}

	// A spy, by default, retains behavioir of the code of the original class
	@Test
	void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("First String");
		System.out.println(arrayListSpy.get(0)); // First String
		System.out.println(arrayListSpy.size()); // 1
		arrayListSpy.add("Some String");
		arrayListSpy.add("Another String");
		System.out.println(arrayListSpy.size()); // 3

		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size()); // 5

		arrayListSpy.add("Some Another String");
		System.out.println(arrayListSpy.size()); // 5

		verify(arrayListSpy).add("Some Another String");
	}
}
