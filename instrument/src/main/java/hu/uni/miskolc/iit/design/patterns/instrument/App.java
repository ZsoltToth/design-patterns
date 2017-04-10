package hu.uni.miskolc.iit.design.patterns.instrument;

import hu.uni.miskolc.iit.design.patterns.instrument.observers.GreaterThanRule;
import hu.uni.miskolc.iit.design.patterns.instrument.observers.LessThanRule;
import hu.uni.miskolc.iit.design.patterns.instrument.observers.TimeWindowCreator;
import hu.uni.miskolc.iit.design.patterns.instrument.observers.timeserie.DifferenceGreaterThanRule;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	
        Observer[] observers = {
        		new GreaterThanRule(8.0),
        		new LessThanRule(3.0),
        		new TimeWindowCreator(3, new DifferenceGreaterThanRule(4.0))
        };
        Instrument instrument = new Instrument(observers);
        instrument.startMeasurement();
    }
}
