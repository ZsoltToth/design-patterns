package hu.uni.miskolc.iit.design.patterns.chart;

import java.awt.*;

/**
 * Created by tothzs on 2018.02.26..
 */
public abstract class ChartPlotter {

    public enum ImageFormats {
        PNG, JPG, EPS
    }

    private int width;
    private double height;
    private ImageFormats outputFormat;

    public ChartPlotter(int width, double height, ImageFormats outputFormat) {
        this.width = width;
        this.height = height;
        this.outputFormat = outputFormat;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public ImageFormats getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(ImageFormats outputFormat) {
        this.outputFormat = outputFormat;
    }

    public abstract Image plot(Chart chart) throws UnableToPlotException;
}
