package hu.uni.miskolc.iit.design.patterns.plum.machine;

import java.util.Date;

/**
 * Created by tothzs on 2018.03.05..
 */
public class Event {
    private Date date;
    private int code;
    private String description;

    public Event(Date date, int code, String description) {
        this.date = date;
        this.code = code;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "date=" + date +
                ", code=" + code +
                ", description='" + description + '\'' +
                '}';
    }

    protected Date getDate() {
        return date;
    }

    protected int getCode() {
        return code;
    }

    protected String getDescription() {
        return description;
    }
}
