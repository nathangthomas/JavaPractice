package com.allstate.exceptions;

import java.util.Date;

public class OutOfRangeException extends Exception {
    private Date timestamp = new Date();
    private int severity = 0;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }


    public OutOfRangeException(String message) {
        super(message);
    }

    public OutOfRangeException(String message, int severity) {
        super(message);
        this.severity = severity;
    }


}
