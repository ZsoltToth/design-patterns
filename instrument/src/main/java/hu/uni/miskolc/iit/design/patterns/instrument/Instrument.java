package hu.uni.miskolc.iit.design.patterns.instrument;

public class Instrument {

	private Observer[] observers;

	private long[] times = { 0, 1, 3, 4, 5, 6 };
	private double[] values = { 0.0, 10.2, 9.0, 6.5, 3.0, -1.0 };

	public Instrument(Observer[] observers) {
		super();
		this.observers = observers;
	}
	
	public void startMeasurement() throws InterruptedException{
		for(int i = 0; i < times.length; i++){
			for(Observer observer : observers){
				observer.observeMeasurement(times[i], values[i]);
			}
			Thread.sleep(1000);
		}
	}

}
