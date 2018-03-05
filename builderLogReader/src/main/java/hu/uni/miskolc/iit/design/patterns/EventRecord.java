package hu.uni.miskolc.iit.design.patterns;

import java.util.Date;

/**
 * Created by tothzs on 2018.03.05..
 */
public class EventRecord {

    private Date occured;
    private String note;

    public EventRecord(Date occured, String note) {
        this.occured = occured;
        this.note = note;
    }

    public Date getOccured() {
        return occured;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "EventRecord{" +
                "occured=" + occured +
                ", note='" + note + '\'' +
                '}';
    }
}
