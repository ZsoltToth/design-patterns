package hu.uni.miskolc.iit.design.patterns.functions;

/**
 * Created by tothzs on 2018.02.19..
 */
public class LinearFunctionFactory extends FunctionFactory {

    private double m;
    private double b;

    public LinearFunctionFactory(double m, double b) {
        this.m = m;
        this.b = b;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public RealFunction createFunction() {
        return new Polynomial(new double[] {b,m});
    }
}
