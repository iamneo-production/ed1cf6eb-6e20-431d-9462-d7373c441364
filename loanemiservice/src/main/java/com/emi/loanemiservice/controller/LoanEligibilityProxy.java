package com.emi.loanemiservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("eligibility-service")
public interface LoanEligibilityProxy {
    @PostMapping(path = "/check-loan-eligibility",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Message checkLoanEligibility(@RequestBody Customer customer);
}