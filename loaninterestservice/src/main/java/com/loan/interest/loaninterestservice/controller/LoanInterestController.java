package com.loan.interest.loaninterestservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/interest/")
public class LoanInterestController {
    @GetMapping("/get-interest-rate/{loanType}")
    public int getInterestRate(@PathVariable String loanType) {
        int interestRate = 0;

        if ( loanType != null && loanType.equals("Home Loan") ) {
             interestRate = 10;
        } else if ( loanType != null && loanType.equals("Personal Loan") ) {
             interestRate = 8;
        } else if ( ( loanType != null && loanType.equals("Gold Loan")) ) {
             interestRate = 7;
        }

        return interestRate;
    }
}
