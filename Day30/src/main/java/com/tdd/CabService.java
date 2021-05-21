package com.tdd;

public class CabService {

	private static final double NORMAL_MINIMUM_COST_PER_KM = 10.0;
	private static final double PREMUIM_MINIMUM_COST_PER_KM = 15;
	private static final int NORMAL_COST_PER_TIME = 1;
	private static final int PREMUIM_COST_PER_TIME = 2;
	private static final double NORMAL_MINIMUM_FARE = 5;
	private static final double PREMUIM_MINIMUM_FARE = 20;

	public double calculateFare(double distance, int time) {
		double totalFare =  distance * NORMAL_MINIMUM_COST_PER_KM + time * NORMAL_COST_PER_TIME;
		if(totalFare < NORMAL_MINIMUM_FARE)
			return NORMAL_MINIMUM_FARE;
		return totalFare;
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
	public double calculateFare(String choice, double distance, int time) {
		double totalFare = 0;
		if(choice.equalsIgnoreCase("Normal")) {
				totalFare = distance * NORMAL_MINIMUM_COST_PER_KM + time * NORMAL_COST_PER_TIME;
				if(totalFare < NORMAL_MINIMUM_FARE)		
					return NORMAL_MINIMUM_FARE;
		}else if(choice.equalsIgnoreCase("Premuim")) {
			totalFare = distance * PREMUIM_MINIMUM_COST_PER_KM + time * PREMUIM_COST_PER_TIME;
			if(totalFare < PREMUIM_MINIMUM_FARE)		
				return PREMUIM_MINIMUM_FARE;
		}
		return totalFare;
	}
}
