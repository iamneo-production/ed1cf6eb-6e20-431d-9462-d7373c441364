package com.loanValidationService.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private int accountnumber;
    private double netIncome;
    private double loanRange;

    private double loanLimit;
    private int creditScore;


    public double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public CustomerDetails() {
    }



    public CustomerDetails(int account_number, double net_income, double loan_range, int isEligible,double loanLimit) {
        this.accountnumber = account_number;
        this.netIncome = net_income;
        this.loanLimit = loanLimit;
        this.creditScore = isEligible;

        if (net_income < 50000) {
            this.loanRange = 12;
        } else if (net_income < 100000) {
            this.loanRange = 36;
        } else {
            this.loanRange = 72;
        }
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public int getAccount_number() {
        return accountnumber;
    }

    public void setAccount_number(int account_number) {
        this.accountnumber = account_number;
    }

    public double getNet_income() {
        return netIncome;
    }

    public void setNet_income(double net_income) {
        this.netIncome=net_income;
    }

    public double getLoan_range() {
        return loanRange;
    }



    public int getCreditScore() {
        return creditScore;
    }

    public void setcreditScore(int creditScore) {
        creditScore = creditScore;
    }
}
