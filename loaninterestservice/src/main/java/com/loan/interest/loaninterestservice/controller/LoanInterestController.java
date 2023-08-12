package com.loan.interest.loaninterestservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/interest/")
public class LoanInterestController {
    @GetMapping("/get-interest-rate")
    public int getInterestRate(@PathVariable String loanType) {

        int interestRate = 0;

        switch (loanType) {
            case "Personal Loan" : interestRate = 10; break;
            case "Home Loan" : interestRate = 8; break;
            case "Gold Loan" : interestRate = 7; break;
        }
        return interestRate;
    }
}
