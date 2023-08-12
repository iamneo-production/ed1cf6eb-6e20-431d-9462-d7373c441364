package com.emi.loanemiservice.proxy;

import com.emi.emiservice.model.Customer;
import com.emi.emiservice.model.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("eligibility-service")
public class LoanEligibilityProxy {
    @PostMapping(path = "/check-loan-eligibility",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    Message checkLoanEligibility(@RequestBody Customer customer);
}
