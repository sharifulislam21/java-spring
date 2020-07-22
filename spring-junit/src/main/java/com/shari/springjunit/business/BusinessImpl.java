package com.shari.springjunit.business;

import java.util.Arrays;

import com.shari.springjunit.data.DataService;

public class BusinessImpl {

	private DataService dataService;

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	public int calculateSum(int[] data) {
		int sum = 0;
		for (int value : data) {
			sum += value;
		}
		return sum;
	}

	// FunctionalProgramming using Java 8 streams
	public int calculateSumUsingStreams(int[] data) {

		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}

	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data = dataService.retrieveAllData();
		for (int value : data) {
			sum += value;
		}
		return sum;
	}
}
