package hu.uni.miskolc.iit.design.patterns;

import hu.uni.miskolc.iit.design.patterns.functions.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

//        FunctionFactory functionFactory = new SinusFunctionFactory(3,Math.PI,100);
        RealFunction[] functions = new RealFunction[]{
                new SinusFunctionFactory(100,1,0).createFunction(),
                new LinearFunctionFactory(2,-1).createFunction(),
                new QuadraticFunctionFactory(-3,2,-1).createFunction()
        };
        for(int i = 0; i < 1e3; i++){
            double x = (double)i / 1e2;
            System.out.println(String.format("%f %f %f %f",
                    x,
                    functions[0].value(x),
                    functions[1].value(x),
                    functions[2].value(x)));
        }
    }
}
