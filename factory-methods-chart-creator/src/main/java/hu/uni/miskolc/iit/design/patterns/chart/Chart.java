package hu.uni.miskolc.iit.design.patterns.chart;

import hu.uni.miskolc.iit.design.patterns.functions.RealFunction;

import java.util.Collection;
import java.util.List;

/**
 * Created by tothzs on 2018.02.19..
 */
public class Chart {

    private double intervalBegin;
    private double intervalEnd;
    private double stepSize;
    private List<RealFunction> functions;
    private Axis xAxis;
    private Axis yAxis;

    public Chart(double intervalBegin, double intervalEnd, double stepSize, List<RealFunction> functions) {
        this.intervalBegin = intervalBegin;
        this.intervalEnd = intervalEnd;
        this.stepSize = stepSize;
        this.functions = functions;
        this.xAxis = new Axis("x");
        this.yAxis = new Axis("y");
    }

    public Chart(double intervalBegin, double intervalEnd, double stepSize, List<RealFunction> functions, Axis xAxis, Axis yAxis) {
        this.intervalBegin = intervalBegin;
        this.intervalEnd = intervalEnd;
        this.stepSize = stepSize;
        this.functions = functions;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public double getIntervalBegin() {
        return intervalBegin;
    }

    public void setIntervalBegin(double intervalBegin) {
        this.intervalBegin = intervalBegin;
    }

    public double getIntervalEnd() {
        return intervalEnd;
    }

    public void setIntervalEnd(double intervalEnd) {
        this.intervalEnd = intervalEnd;
    }

    public double getStepSize() {
        return stepSize;
    }

    public void setStepSize(double stepSize) {
        this.stepSize = stepSize;
    }

    public List<RealFunction> getFunctions() {
        return functions;
    }

    public void setFunctions(List<RealFunction> functions) {
        this.functions = functions;
    }



    public String lookupTable() {
        StringBuilder result = new StringBuilder();
        double x = intervalBegin;
        do {
            result.append(x + " ");
            for (int i = 0; i < functions.size(); i++) {
                result.append(functions.get(i).value(x) + " ");
            }
            result.append("\n");
        } while ((x += stepSize) <= intervalEnd);
        return result.toString();
    }
}
