package hu.uni.miskolc.iit.design.patterns.functions;

/**
 * Created by tothzs on 2018.02.19..
 */
public class Sinus implements RealFunction {

    private double amplitude;
    private double frequence;
    private double phase;

    /**
     * It should be instantiated with {@link SinusFunctionFactory}
     * @param amplitude
     * @param frequence
     * @param phase
     */
    protected Sinus(double amplitude, double frequence, double phase) {
        this.amplitude = amplitude;
        this.frequence = frequence;
        this.phase = phase;
    }

    public double value(double x) {
        return amplitude*Math.sin((frequence*x)+phase);
    }
}
