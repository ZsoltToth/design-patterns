package hu.uni.miskolc.iit.design.patterns.instrument.observers;

import hu.uni.miskolc.iit.design.patterns.instrument.Observer;

public class LessThanRule implements Observer {

	private double limit;

	public LessThanRule(double limit) {
		super();
		this.limit = limit;
	}

	public void observeMeasurement(long time, double value) {
		if (value < limit) {
			System.out.println(String.format("Value (%f) is less than limit (%f) at time (%d)", value, limit, time));
		}

	}

}
