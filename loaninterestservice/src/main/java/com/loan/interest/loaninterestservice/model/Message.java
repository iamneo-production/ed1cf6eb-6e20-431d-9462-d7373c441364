package com.loan.interest.loaninterestservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    @JsonProperty("message")
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
