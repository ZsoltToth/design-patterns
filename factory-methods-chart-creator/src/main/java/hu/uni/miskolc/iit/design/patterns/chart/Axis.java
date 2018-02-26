package hu.uni.miskolc.iit.design.patterns.chart;

/**
 * Created by tothzs on 2018.02.26..
 */
public class Axis {
    public enum AxisType{
        LINEAR, LOGARITHMIC, DATE
    }
    private String title;
    private AxisType type;

    public Axis(String title, AxisType type) {
        this.title = title;
        this.type = type;
    }

    public Axis(String title) {
        this(title, AxisType.LINEAR);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AxisType getType() {
        return type;
    }

    public void setType(AxisType type) {
        this.type = type;
    }
}
