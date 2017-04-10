package hu.uni.miskolc.iit.design.patterns.instrument.observers;

import java.util.LinkedList;
import java.util.Queue;

import hu.uni.miskolc.iit.design.patterns.instrument.Observer;
import hu.uni.miskolc.iit.design.patterns.instrument.TimeSerieObserver;

public class TimeWindowCreator implements Observer, TimeSerieObserver {
	
	private final int windowSize;
	private Queue<Long> timeQueue;
	private Queue<Double> valueQueue;
	private TimeSerieObserver[] observers;
	
	public TimeWindowCreator(int windowSize, TimeSerieObserver... observers ) {
		super();
		this.windowSize = windowSize;
		this.timeQueue = new LinkedList<Long>();
		this.valueQueue = new LinkedList<Double>();
		this.observers = observers;
	}



	public void observeMeasurement(long time, double value) {
		timeQueue.add(time);
		valueQueue.add(value);
		if(timeQueue.size() > windowSize){
			timeQueue.remove();
		}
		if(valueQueue.size() > windowSize){
			valueQueue.remove();
		}
		Long[] times = timeQueue.toArray(new Long[timeQueue.size()]);
		Double[] values = valueQueue.toArray(new Double[valueQueue.size()]);
		this.processTimeSerie(times, values);
	}



	public void processTimeSerie(Long[] time, Double[] value) {
		for(TimeSerieObserver observer : observers){
			observer.processTimeSerie(time, value);
		}
	}

}
