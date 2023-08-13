package com.loan.emi.emiservice.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@RestController
@RequestMapping("/emi/")
public class LoanEmiServiceController {
    public static final String CUSTOMER_VALIDATION_SUCCESSFUL = "Customer Loan Validation Successfull";
    public static final String LOAN_ELIGIBILITY_SUCCESSFUL = "Customer Loan Eligibility Successfull";
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

    @PostMapping("/calculate-emi")
    public Message calculateEmi(@RequestBody Customer customer) {
        Assert.notNull(customer, "Customer should be not null.");
        CustomerMessage customerMessage = null;
        Message message = null;
        Message validateLoanMessage = validationProxy.validateLoanDetails(customer);
        if ( Objects.nonNull(validateLoanMessage) && validateLoanMessage.getMessage().equals(CUSTOMER_VALIDATION_SUCCESSFUL) ) {
            Message loanEligibilityMessage = eligibilityProxy.checkLoanEligibility(customer);
            if ( Objects.nonNull(loanEligibilityMessage) && validateLoanMessage.getMessage().equals(LOAN_ELIGIBILITY_SUCCESSFUL) ) {
                int interestRate = interestRateProxy.getInterestRate(customer.getLoanType());

                 String messagestr = "Dear " + customer.getCustomerName()
                        + ", You are eligible for " + customer.getLoanType() + " of " + customer.getLaonAmount() +", with Interest Rate of "
                        + interestRate + " for the Period of " + customer.getDuration();
                customerMessage = new CustomerMessage();                
                customerMessage.setCustomerMessage(messagestr); 
                logger.info(messagestr);
            } else {
                message = new Message(EMI_CALCULATION_FAILED_DUE_TO_CUSTOMER_ELIGIBILITY_FAILED);
                logger.info(message.getMessage()); 
            }
        } else {
            message = new Message(EMI_CALCULATION_FAILED_DUE_TO_CUSTOMER_VALIDATION_FAILED);
            logger.info(message.getMessage()); 
        }
        message = customerNotificationProxy.customerNotification(customerMessage);                       
        if (Objects.nonNull(message)) {
            logger.info("Message : " + message.getMessage());
        }
        return message;
    }
}
