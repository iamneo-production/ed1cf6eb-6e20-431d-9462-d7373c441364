package com.emi.loanemiservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("interest-service")
public class InterestRateProxy {
    @GetMapping("/get-interest-rate")
    int getInterestRate(@PathVariable String loanType);
}
