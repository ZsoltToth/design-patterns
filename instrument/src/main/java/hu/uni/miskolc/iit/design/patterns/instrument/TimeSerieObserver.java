package hu.uni.miskolc.iit.design.patterns.instrument;

public interface TimeSerieObserver {

	void processTimeSerie(Long[] time, Double[] value);
}
