package hu.uni.miskolc.iit.design.patterns.instrument.observers;

import hu.uni.miskolc.iit.design.patterns.instrument.Observer;

public class GreaterThanRule implements Observer {

	private double limit;

	public GreaterThanRule(double limit) {
		super();
		this.limit = limit;
	}

	public void observeMeasurement(long time, double value) {
		if(value > limit){
			System.out.println(String.format(
					"Value (%f) is bigger than limit (%f) at time (%d)",
					value, limit, time));
		}
	}

}
