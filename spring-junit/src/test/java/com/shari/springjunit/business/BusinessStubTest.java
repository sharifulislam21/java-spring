package com.shari.springjunit.business;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.shari.springjunit.data.DataService;

class DataServiceStub implements DataService {

	@Override
	public int[] retrieveAllData() {
		
		return new int[] {1,2,3};
	}	
}

class DataServiceEmptyStub implements DataService {

	@Override
	public int[] retrieveAllData() {
		
		return new int[] {};
	}	
}

class DataServiceOneElementStub implements DataService {

	@Override
	public int[] retrieveAllData() {
		
		return new int[] {3};
	}	
}

class BusinessStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {

		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataService_empty() {

		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceEmptyStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_oneElement() {

		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceOneElementStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 3;
		assertEquals(expectedResult, actualResult);
	}
}
