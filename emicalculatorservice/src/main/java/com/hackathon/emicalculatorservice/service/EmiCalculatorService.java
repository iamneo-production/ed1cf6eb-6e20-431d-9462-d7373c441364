package com.hackathon.emicalculatorservice.service;

import com.emiCalculatorService.dto.CalculateEmi;
import com.emiCalculatorService.feignClient.FeignClientUtil;
import com.emiCalculatorService.dto.loanValidation;
import com.emiCalculatorService.feignClient.InterestFeignClient;
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


    public LoanDetails savedetails(LoanDetails loanDetails) {
        return emirepo.save(loanDetails);

    }

    public List<LoanDetails> getDetails(){

        return (List<LoanDetails>)emirepo.findAll();
    }

    @CircuitBreaker(name="emiservice",fallbackMethod = "failureMethod")
    public double calculateEMI(LoanDetails loanDetails) {

        loanValidation loan = loanValidation.builder()
                .accountNumber(loanDetails.getAccountNumber())
                .loanAmount(loanDetails.getLoanAmount())
                .build();

        boolean status=feignClientUtil.checkLoanAmount(loan);
        if(status){
            double principal = loanDetails.getLoanAmount();
            //double rate = loanDetails.getInterestRate() / 12 / 100;
            int tenure = loanDetails.getLoanTenure();

           double rate=interestFeignClient.requestRate();

            logger.info(String.valueOf(rate));

            double emi = (principal * rate * Math.pow(1 + rate, tenure)) / (Math.pow(1 + rate, tenure) - 1);

            CalculateEmi calculateEmi=CalculateEmi.builder()
                    .accountNumber(loanDetails.getAccountNumber())
                    .emi(emi)
                    .build();

            String notification=notificationFeignClient.successNotification(calculateEmi);
            logger.info(notification);
            return emi;


        }
        return 0.0;

    }

    public double failureMethod(Exception e){
        return 0.0;
    }
}
