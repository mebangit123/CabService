package com.tdd;

public class CabService {

	private static final double MINIMUM_COST_PER_KM = 10.0;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;

	public double calculateFare(double distance, int time) {
		double totalFare =  distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
//		if(totalFare < MINIMUM_FARE)
//			return MINIMUM_FARE;
//		return totalFare;
		return Math.max(totalFare, MINIMUM_FARE);
	}
	public double calculateMultipleRideFare(Ride[] ride) {
		double totalFare = 0;
		for(Ride rides : ride) {
			totalFare += this.calculateFare(rides.distance, rides.time);
		}
		return totalFare;
	}
	
	public InVoiceSummary calculateFare(Ride[] ride) {
		double totalFare = 0;
		for(Ride rides : ride) {
			totalFare += this.calculateFare(rides.distance, rides.time);
		}
		return new InVoiceSummary(ride.length, totalFare);
	}
}
