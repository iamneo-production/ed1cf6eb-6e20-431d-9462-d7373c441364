package com.loan.eligibility.loaneligibilityservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.loan.eligibility.loaneligibilityservice.model.Customer;
import com.loan.eligibility.loaneligibilityservice.model.Message;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/eligibility/")
public class LoanEligibilityController {
    
    @PostMapping("/check-loan-eligibility")
    Message checkLoanEligibility(@RequestBody Customer customer) {
        Message message;

        if( customer.getAge() >= 55 && 
                ((customer.getLoanType().equals("Home Loan") && (customer.getLaonAmount() > 5000000) && customer.getDuration() > 25)
                || (customer.getLoanType().equals("Personal Loan") && (customer.getLaonAmount() > 3000000) && customer.getDuration() > 5)
                || (customer.getLoanType().equals("Gold Loan") && (customer.getLaonAmount() > 1000000) && customer.getDuration() > 2)) )
        {
            message = new Message("Customer Loan Eligibility Failed");
        } else {
            message = new Message( "Customer Loan Eligibility Successfull");
        }

        return message;
    }
  
}
