package com.loan.eligibility.loaneligibilityservice.controller;

import com.emi.emiservice.model.Customer;
import com.emi.emiservice.model.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanEligibilityController {
    @PostMapping("/check-loan-eligibility")
    Message checkLoanEligibility(@RequestBody Customer customer) {
        Message message;

        if( customer.getAge() >= 55
                && (customer.getLoanType().equals("Home Loan") && Double.compare(customer.getLaonAmount(), Double.valueOf(5000000)) > 0 && customer.getDuration() > 25)
                && (customer.getLoanType().equals("Personal Loan") && Double.compare(customer.getLaonAmount(), Double.valueOf(3000000)) > 0 && customer.getDuration() > 5)
                && (customer.getLoanType().equals("Gold Loan") && Double.compare(customer.getLaonAmount(), Double.valueOf(1000000)) > 0 && customer.getDuration() > 2) )
        {
            message = new Message("Customer Loan Eligibility Failed");
        } else {
            message = new Message( "Customer Loan Eligibility Successful");
        }

        return message;
    }
}
