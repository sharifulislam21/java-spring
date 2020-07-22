package com.shari.springjunit.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shari.springjunit.data.DataService;

class BusinessMockTest {
	
	BusinessImpl business = new BusinessImpl();
	DataService dataServiceMock = mock(DataService.class);
	
	//For JUnit5, @BeforeEach
	//For JUnit 4 and Earlier, @Before
	@BeforeEach
	public void before() {
		business.setDataService(dataServiceMock);

	}
	
	@Test
	public void calculateSumUsingDataService_basic() {

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6, business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_empty() {

		//BusinessImpl business = new BusinessImpl();
		//DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		//business.setDataService(dataServiceMock);
		
		//int actualResult = business.calculateSumUsingDataService();
		//int expectedResult = 0;
		assertEquals(0, business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingDataService_oneElement() {

		//BusinessImpl business = new BusinessImpl();
		//DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {3});
		//business.setDataService(dataServiceMock);
		
		//int actualResult = business.calculateSumUsingDataService();
		//int expectedResult = 3;
		assertEquals(3, business.calculateSumUsingDataService());
	}
}
