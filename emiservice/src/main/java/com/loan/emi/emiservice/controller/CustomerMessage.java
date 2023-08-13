package com.loan.emi.emiservice.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerMessage {
    @JsonProperty("customerMessage")
    public String customerMessage;

    public String getCustomerMessage() {
        return customerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        this.customerMessage = customerMessage;
    } 
}
