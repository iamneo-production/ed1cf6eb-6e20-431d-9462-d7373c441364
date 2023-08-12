package com.rmi.loaneligibilityservice.controller;

import com.emi.emiservice.model.Customer;
import com.emi.emiservice.model.Message;
import com.emi.emiservice.proxy.CustomerNotificationProxy;
import com.emi.emiservice.proxy.InterestRateProxy;
import com.emi.emiservice.proxy.LoanEligibilityProxy;
import com.emi.emiservice.proxy.LoanValidationProxy;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class LoanEmiServiceController {
    public static final String CUSTOMER_VALIDATION_SUCCESSFUL = "Customer Loan Validation Successful";
    public static final String LOAN_ELIGIBILITY_SUCCESSFUL = "Customer Loan Eligibility Successful";
    public static final String EMI_CALCULATION_FAILED_DUE_TO_CUSTOMER_ELIGIBILITY_FAILED = "Emi calculation Failed due to Customer eligibility";
    public static final String EMI_CALCULATION_FAILED_DUE_TO_CUSTOMER_VALIDATION_FAILED = "Emi calculation Failed due to Customer Validation";
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoanValidationProxy validationProxy;

    @Autowired
    private LoanEligibilityProxy eligibilityProxy;

    @Autowired
    private InterestRateProxy interestRateProxy;

    @Autowired
    private CustomerNotificationProxy customerNotificationProxy;

    @PostMapping("/calculateEmi")
    public Message calculateEmi(@RequestBody Customer customer) {
        Assert.notNull(customer, "Customer should be not null.");
        Message message = null;
        Message validateLoanMessage = validationProxy.validateLoanDetails(customer);
        if ( Objects.nonNull(validateLoanMessage) && validateLoanMessage.getMessage().equals(CUSTOMER_VALIDATION_SUCCESSFUL) ) {
            Message loanEligibilityMessage = eligibilityProxy.checkLoanEligibility(customer);
            if ( Objects.nonNull(validateLoanMessage) && validateLoanMessage.getMessage().equals(LOAN_ELIGIBILITY_SUCCESSFUL) ) {
                int interestRate = interestRateProxy.getInterestRate(customer.getLoanType());

                 message= new Message("Dear " + customer.getCustomerName()
                        + ", You are eligible for " + customer.getLoanType() + " of " + customer.getLaonAmount() +", with Interest Rate of "
                        + interestRate + " for the Period of " + customer.getDuration());
            } else {
                message = new Message(EMI_CALCULATION_FAILED_DUE_TO_CUSTOMER_ELIGIBILITY_FAILED);            }
        } else {
            message = new Message(EMI_CALCULATION_FAILED_DUE_TO_CUSTOMER_VALIDATION_FAILED);

        }
        customerNotificationProxy.customerNotification(message);
        return message;

    }
}
