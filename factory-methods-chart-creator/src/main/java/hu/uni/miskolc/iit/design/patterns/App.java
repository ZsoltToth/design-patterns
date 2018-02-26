package hu.uni.miskolc.iit.design.patterns;

import hu.uni.miskolc.iit.design.patterns.chart.Chart;
import hu.uni.miskolc.iit.design.patterns.chart.ChartPlotter;
import hu.uni.miskolc.iit.design.patterns.chart.GNUPlotter;
import hu.uni.miskolc.iit.design.patterns.chart.UnableToPlotException;
import hu.uni.miskolc.iit.design.patterns.functions.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnableToPlotException {
        System.out.println( "Hello World!" );

//        FunctionFactory functionFactory = new SinusFunctionFactory(3,Math.PI,100);
        RealFunction[] functions = new RealFunction[]{
                new SinusFunctionFactory(100,1,0).createFunction(),
                new LinearFunctionFactory(2,-1).createFunction(),
                new QuadraticFunctionFactory(-3,2,-1).createFunction()
        };
        Chart chart = new Chart(0,10,1e-2, Arrays.asList(functions));
        System.out.println(chart.lookupTable());
        ChartPlotter plotter = new GNUPlotter(800,600,ChartPlotter.ImageFormats.PNG);
        Image img = plotter.plot(chart);
        System.out.println(img);
    }
}
