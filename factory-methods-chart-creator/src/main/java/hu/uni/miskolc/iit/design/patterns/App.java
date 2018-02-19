package hu.uni.miskolc.iit.design.patterns;

import hu.uni.miskolc.iit.design.patterns.functions.FunctionFactory;
import hu.uni.miskolc.iit.design.patterns.functions.RealFunction;
import hu.uni.miskolc.iit.design.patterns.functions.SinusFunctionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        FunctionFactory functionFactory = new SinusFunctionFactory(3,Math.PI,100);
        RealFunction function = functionFactory.createFunction();
        for(int i = 0; i < 1e4; i++){
            System.out.println(String.format("%d,%f",i,function.value(((double)i/100))));
        }
    }
}
