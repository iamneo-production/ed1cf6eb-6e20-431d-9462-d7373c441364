package com.emiCalculatorService.service;

import com.emiCalculatorService.dto.*;
import com.emiCalculatorService.feignClient.FeignClientUtil;
import com.emiCalculatorService.feignClient.InterestFeignClient;
import com.emiCalculatorService.feignClient.LoanEligibilityFeignClient;
import com.emiCalculatorService.feignClient.NotificationFeignClient;
import com.emiCalculatorService.model.LoanDetails;
import com.emiCalculatorService.repository.EmiCalculatorRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmiCalculatorService {

    private static final Logger logger = LoggerFactory.getLogger(EmiCalculatorService.class);
    @Autowired
    public EmiCalculatorRepository emirepo;

    @Autowired
    public FeignClientUtil feignClientUtil;
    @Autowired
    public NotificationFeignClient notificationFeignClient;
    @Autowired
    public InterestFeignClient interestFeignClient;

    @Autowired
    public LoanEligibilityFeignClient loanEligibilityFeignClient;


    public LoanDetails savedetails(LoanDetails loanDetails) {
        return emirepo.save(loanDetails);

    }

    public List<LoanDetails> getDetails(){

        return (List<LoanDetails>)emirepo.findAll();
    }

    @CircuitBreaker(name="emiservice",fallbackMethod = "failureMethod")
    public NotificationResponce calculateEMI(LoanDetails loanDetails) {

        loanValidation loan = loanValidation.builder()
                .accountNumber(loanDetails.getAccountNumber())
                .loanAmount(loanDetails.getLoanAmount())
                .build();

        ValidationResponce validationResponce =feignClientUtil.checkLoanAmount(loan);
        if(validationResponce.isValidation()){
            double principal = loanDetails.getLoanAmount();
            //double rate = loanDetails.getInterestRate() / 12 / 100;
            int tenure = loanDetails.getLoanTenure();

           InterestRateResponse interestRateResponse=interestFeignClient.requestRate(loanDetails.getLoanType());
           double rate =interestRateResponse.getLoanRate();
            logger.info(String.valueOf(rate));
            LoanEligibilityRequest loanEligibilityRequest=LoanEligibilityRequest.builder()
                    .loanAmount(validationResponce.getLoanAmount())
                    .income(validationResponce.getIncome())
                    .creditScore(validationResponce.getCreditScore())
                    .build();
            EligibilityResponse eligibilityResponse =loanEligibilityFeignClient.checkLoanEligibility(loanEligibilityRequest);

            double  emi = 0.0;
            String status="";
            if (eligibilityResponse.isEligible()) {
                emi = (principal * rate * Math.pow(1 + rate, tenure)) / (Math.pow(1 + rate, tenure) - 1);;
                status="Success";
            }else{

                status="Not Eligible";
            }


            CalculateEmi calculateEmi=CalculateEmi.builder()
                    .accountNumber(loanDetails.getAccountNumber())
                    .emi(emi)
                    .build();

            NotificationRequest notificationRequest=NotificationRequest.builder()
                    .status(status)
                    .emivalue(emi)
                    .accountNumber(loanDetails.getAccountNumber())
                    .build();

            NotificationResponce notification=notificationFeignClient.successNotification(notificationRequest);
            //logger.info(notification);
            return notification;


        }
        else{
            logger.info("not validate");
        }

        NotificationRequest notificationRequest=NotificationRequest.builder()
                .status("Failed")
                .emivalue(0.0)
                .accountNumber(loanDetails.getAccountNumber())
                .build();
        NotificationResponce notification=notificationFeignClient.successNotification(notificationRequest);
        return notification;
    }

    public NotificationResponce failureMethod(Exception e){
        NotificationRequest notificationRequest=NotificationRequest.builder()
                .status("Service Down")
                .emivalue(0.0)
                .accountNumber(00000)
                .build();
        NotificationResponce notification=notificationFeignClient.successNotification(notificationRequest);
        return notification;
    }
}