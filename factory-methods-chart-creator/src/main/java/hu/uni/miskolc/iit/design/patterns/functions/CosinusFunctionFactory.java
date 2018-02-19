package hu.uni.miskolc.iit.design.patterns.functions;

/**
 * Created by tothzs on 2018.02.19..
 */
public class CosinusFunctionFactory extends FunctionFactory{

    private double amplitude;
    private double frequence;
    private double phase;

    public CosinusFunctionFactory(double amplitude, double frequence, double phase) {
        this.amplitude = amplitude;
        this.frequence = frequence;
        this.phase = phase;
    }

    public double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(double amplitude) {
        this.amplitude = amplitude;
    }

    public double getFrequence() {
        return frequence;
    }

    public void setFrequence(double frequence) {
        this.frequence = frequence;
    }

    public double getPhase() {
        return phase;
    }

    public void setPhase(double phase) {
        this.phase = phase;
    }

    public RealFunction createFunction() {
        return new Cosinus(amplitude,frequence,phase);
    }
}
