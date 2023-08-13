package com.loan.emi.emiservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("validation-service")
public interface LoanValidationProxy {
    @PostMapping("/validation/validate-loan-details")
    public boolean validateLoanDetails(@RequestBody Customer customer);
}

