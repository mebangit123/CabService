package com.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabServiceTest {
	CabService cabservice = null;
	
	@Before
	public void setUp() throws Exception {
		cabservice = new CabService();
	}
//	@Test
//	public void givenDistanceAndTimeShouldReturnTotalFare() {
//		final double distance = 2.0;
//		final int minute = 5;
//		double totalFare = cabservice.calculateFare(distance, minute);
//		Assert.assertEquals(25, totalFare, 0);
//	}
	@Test
	public void givenLessDistanceAndTimeShouldReturnMinFare() {
		final double distance = 0.1;
		final int minute = 1;
		double totalFare = cabservice.calculateFare("Premuim",distance, minute);
		Assert.assertEquals(20, totalFare, 0);
	}
	@Test
	public void givenMultipleRidesShouldReturnTotalFare() {
		Ride[] rides = {new Ride(2.0, 5),
						new Ride(0.1, 1)
		};
		double fare = cabservice.calculateMultipleRideFare(rides);
		Assert.assertEquals(30, fare, 0);
	}
	@Test
	public void givenMultipleRidesShouldReturnInvoiceSummary() {
		Ride[] rides = {new Ride(2.0, 5),
						new Ride(0.1, 1)
		};
		InVoiceSummary summary = cabservice.calculateFare(rides);
		InVoiceSummary expectedInvoiceSummary = new InVoiceSummary(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
	@Test
	public void givenDistanceAndTimeForNormalRideShouldReturnTotalFare() {
		final double distance = 2.0;
		final int minute = 5;
		double totalFare = cabservice.calculateFare("Normal",distance, minute);
		Assert.assertEquals(25, totalFare, 0);
	}
}
