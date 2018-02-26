package hu.uni.miskolc.iit.design.patterns.chart;

/**
 * Created by tothzs on 2018.02.26..
 */
public class UnableToPlotException extends Exception {
    public UnableToPlotException() {
    }

    public UnableToPlotException(String message) {
        super(message);
    }

    public UnableToPlotException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnableToPlotException(Throwable cause) {
        super(cause);
    }

    public UnableToPlotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
