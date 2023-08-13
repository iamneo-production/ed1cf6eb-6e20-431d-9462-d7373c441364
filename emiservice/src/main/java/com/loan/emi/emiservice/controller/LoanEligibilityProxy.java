package com.loan.emi.emiservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("eligibility-service")
public interface LoanEligibilityProxy {
    @PostMapping("/eligibility/check-loan-eligibility")
    public boolean checkLoanEligibility(@RequestBody Customer customer);
}

