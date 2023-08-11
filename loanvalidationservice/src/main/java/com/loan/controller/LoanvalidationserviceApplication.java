package com.loan.controller;

import com.emi.emiservice.model.Customer;
import com.emi.emiservice.model.Message;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validation/")
public class LoanvalidationserviceApplication {
    private org.slf4j.Logger logger= LoggerFactory.getLogger(this.getClass());

    @PostMapping("/validate-loan-details")
    public Message validateLoanDetails(@RequestBody Customer customer) {
        Assert.notNull(customer, "Customer should not be empty");
        Message message = null;

        boolean ageValidation = customer.getAge() >= 50;
        boolean validSSN = customer.getSsn().length() == 9;

        if (ageValidation && validSSN) {
            return new Message("Customer Loan Validation Successful");
        }

        return new Message("Customer Loan Validation Failed");
    }
}
