package com.loan.customer.customernotificationservice.model;

public class Message {
    public String message;

    public Message(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }    
}
