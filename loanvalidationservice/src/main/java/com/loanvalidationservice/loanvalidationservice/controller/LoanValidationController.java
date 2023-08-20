package com.loanValidationService.controller;

import com.loanValidationService.dto.LoanDetails;
import com.loanValidationService.dto.ValidationResponce;
import com.loanValidationService.service.LoanValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validation")
public class LoanValidationController {

    @Autowired
    public LoanValidationService loanValidationService;

    @PostMapping("/checkValidation")
    public ValidationResponce checkLoanAmount(@RequestBody LoanDetails loanDetails){

        return loanValidationService.check_loan_validation(loanDetails);
    }


}
