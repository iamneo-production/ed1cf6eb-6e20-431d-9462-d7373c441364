package com.loan.validation.loanvalidationservice.controller;

import com.loan.validation.loanvalidationservice.model.Customer;
import com.loan.validation.loanvalidationservice.model.Message;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/validation/")
public class LoanvalidationserviceApplication {
    private org.slf4j.Logger logger= LoggerFactory.getLogger(this.getClass());

    @PostMapping("/validate-loan-details")
    public Message validateLoanDetails(@RequestBody Customer customer) {
        Assert.notNull(customer, "Customer should not be empty");
        Message message = null;

        boolean ageValidation = customer.getAge() <= 50;
        boolean validSSN = customer.getSsn().length() == 9;

        if (ageValidation && validSSN) {
            logger.info("Customer Loan Validation Successful");
            return new Message("Customer Loan Validation Successful");
        }

        logger.info("Customer Loan Validation Failed");
        return new Message("Customer Loan Validation Failed");
    }
}
