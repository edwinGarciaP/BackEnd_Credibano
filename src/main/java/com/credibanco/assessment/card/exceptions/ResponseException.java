package com.credibanco.assessment.card.exceptions;

import java.util.Date;

public class ResponseException {

    private String message;
    private Date date;

    public ResponseException(String message) {
        this.message = message;
        this.date = new Date();

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}