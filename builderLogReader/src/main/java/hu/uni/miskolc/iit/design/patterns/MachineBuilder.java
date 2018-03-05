package hu.uni.miskolc.iit.design.patterns;

import hu.uni.miskolc.iit.design.patterns.Machine;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tothzs on 2018.03.05..
 */
public abstract class MachineBuilder {

    private char commentChar;
    private char fieldSeparator;
    private DateFormat dateFormat;

    protected MachineBuilder(){
        this.commentChar = '#';
        this.fieldSeparator = ':';
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }

    public char getCommentChar() {
        return commentChar;
    }

    public void setCommentChar(char commentChar) {
        this.commentChar = commentChar;
    }

    public char getFieldSeparator() {
        return fieldSeparator;
    }

    public void setFieldSeparator(char fieldSeparator) {
        this.fieldSeparator = fieldSeparator;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public abstract Machine build(File logFile);
}
