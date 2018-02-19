package hu.uni.miskolc.iit.design.patterns.functions;

/**
 * Created by tothzs on 2018.02.19..
 */
public class Polynomial implements RealFunction {

    private double[] weights;

    /**
     * It can be called from {@link LinearFunctionFactory} or {@link QuadraticFunctionFactory}
     * @param weights
     */
    protected Polynomial(double[] weights) {
        this.weights = weights;
    }

    public double value(double x) {
        double sum = 0.0;
        for(int i = 0; i < weights.length; i++){
            sum += weights[i] *  Math.pow(x,i);
        }
        return sum;
    }
}
