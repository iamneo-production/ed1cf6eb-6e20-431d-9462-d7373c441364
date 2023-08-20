package com.loanValidationService.service;

import com.loanValidationService.dto.LoanDetails;
import com.loanValidationService.dto.ValidationResponce;
import com.loanValidationService.model.CustomerDetails;
import com.loanValidationService.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoanValidationService {

    public static final double max_loan_amount= 10000.00;

    @Autowired
    public LoanRepository loanRepository;

    public ValidationResponce check_loan_validation(LoanDetails loanDetails){


        CustomerDetails customer =loanRepository.findByAccountnumber(loanDetails.getAccountNumber());

        boolean isvalidation=true;
        if(customer==null) {

            isvalidation= false;
        }
        else if (customer.getLoanLimit()<loanDetails.getLoanAmount()) {
            isvalidation= false;
        } else if (customer.getLoan_range()<loanDetails.getLoanTenure()) {
            isvalidation= false;
        }
        else{
            isvalidation=true;
        }


        ValidationResponce validationResponce=ValidationResponce.builder()
                .isValidation(isvalidation)
                .loanAmount(loanDetails.loanAmount)
                .income(customer.getNet_income())
                .creditScore(customer.getCreditScore())
                .build();
        return validationResponce;

    }
}
