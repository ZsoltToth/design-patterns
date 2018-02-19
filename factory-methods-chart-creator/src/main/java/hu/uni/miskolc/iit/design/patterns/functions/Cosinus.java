package hu.uni.miskolc.iit.design.patterns.functions;

/**
 * Created by tothzs on 2018.02.19..
 */
public class Cosinus implements RealFunction {

    private double amplitude;
    private double frequence;
    private double phase;

    /**
     * It should be instantiated with {@link CosinusFunctionFactory}
     * @param amplitude
     * @param frequence
     * @param phase
     */
    protected Cosinus(double amplitude, double frequence, double phase) {
        this.amplitude = amplitude;
        this.frequence = frequence;
        this.phase = phase;
    }

    public double value(double x) {
        return amplitude * Math.cos((x/frequence)+phase);
    }
}
