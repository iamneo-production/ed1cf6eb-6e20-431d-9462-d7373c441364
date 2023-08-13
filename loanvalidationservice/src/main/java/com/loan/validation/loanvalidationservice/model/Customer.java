package com.loan.validation.loanvalidationservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    @JsonProperty("customerName")
    private String customerName;

    @JsonProperty("customerName")
    private int custId;

    @JsonProperty("laonAmount")
    private int laonAmount;

    @JsonProperty("age")
    private int age;

    @JsonProperty("ssn")
    private String ssn;

    @JsonProperty("loanType")
    private String loanType;

    @JsonProperty("duration")
    private int duration;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getLaonAmount() {
        return laonAmount;
    }

    public void setLaonAmount(int laonAmount) {
        this.laonAmount = laonAmount;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
