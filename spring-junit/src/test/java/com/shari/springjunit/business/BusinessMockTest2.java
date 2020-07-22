package com.shari.springjunit.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.shari.springjunit.data.DataService;


/*
 * If you are using JUnit 5
 * @ExtendWith(MockitoExtension.class)
 * instead of @RunWith(MockitoJUnitRunner.class)
 *
 **/

@ExtendWith(MockitoExtension.class)
class BusinessMockTest2 {
	
	@InjectMocks
	BusinessImpl business;
	
	@Mock
	DataService dataServiceMock;
	
	@Test
	public void calculateSumUsingDataService_basic() {

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6, business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_empty() {

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingDataService_oneElement() {

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {3});
		assertEquals(3, business.calculateSumUsingDataService());
	}
}
