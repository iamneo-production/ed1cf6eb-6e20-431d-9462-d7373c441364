package com.loan.emi.emiservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("interest-service")
public interface InterestRateProxy {
    @GetMapping("/interest/get-interest-rate/{loanType}")
    public int getInterestRate(@PathVariable String loanType);
}
