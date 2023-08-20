package com.loanservice.loaneglibilityservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loanservice.loaneglibilityservice.model.EligibilityResponse;
import com.loanservice.loaneglibilityservice.model.LoanEligibilityRequest;
import com.loanservice.loaneglibilityservice.service.LoanEligibilityService;



@RestController
public class LoanEligibilityController {

    @Autowired
    private LoanEligibilityService loanEligibilityService;

    @PostMapping("/check-loan-eligibility")
    public EligibilityResponse checkLoanEligibility(@RequestBody LoanEligibilityRequest request) {
        boolean isEligible = loanEligibilityService.checkEligibility(request.getLoanAmount(),request.getIncome(),request.getCreditScore());

        EligibilityResponse response = new EligibilityResponse();
        response.setEligible(isEligible);
        return response;
    }
}
