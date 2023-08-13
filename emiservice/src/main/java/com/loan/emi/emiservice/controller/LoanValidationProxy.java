package com.loan.emi.emiservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("validation-service")
public interface LoanValidationProxy {
    @PostMapping("/validation/validate-loan-details")
    public Message validateLoanDetails(@RequestBody Customer customer);
}

