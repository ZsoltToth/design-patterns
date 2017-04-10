package hu.uni.miskolc.iit.design.patterns.instrument.observers.timeserie;

import hu.uni.miskolc.iit.design.patterns.instrument.TimeSerieObserver;

public class DifferenceGreaterThanRule implements TimeSerieObserver {

	private final double limit;

	public DifferenceGreaterThanRule(double limit) {
		super();
		this.limit = limit;
	}

	public void processTimeSerie(Long[] time, Double[] value) {
		if (time.length < 2 || value.length < 2) {
			return;
		}
		if (time.length != value.length) {
			return;
		}
		double difference = (value[value.length - 1] - value[value.length - 2])
				/ (time[time.length - 1] - time[time.length - 2]);
		if (Math.abs(difference) > limit) {
			System.out.println(String.format("Difference (%f) exceeds limit (%f) between %d - %d", difference, limit,
					time[time.length - 1], time[time.length - 2]));
		}
	}

}
