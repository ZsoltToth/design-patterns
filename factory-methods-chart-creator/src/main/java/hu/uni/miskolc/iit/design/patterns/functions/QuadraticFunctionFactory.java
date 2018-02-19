package hu.uni.miskolc.iit.design.patterns.functions;

/**
 * Created by tothzs on 2018.02.19..
 */
public class QuadraticFunctionFactory extends FunctionFactory {

    private double a,b,c;

    public QuadraticFunctionFactory(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public RealFunction createFunction() {
        return new Polynomial(new double[]{c,b,a});
    }
}
