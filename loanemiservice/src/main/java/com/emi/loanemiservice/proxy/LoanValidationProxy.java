package com.emi.loanemiservice.proxy;

import com.emi.emiservice.model.Customer;
import com.emi.emiservice.model.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("validation-service")
public class LoanValidationProxy {
    @PostMapping(path = "/validate-loan-details",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    Message validateLoanDetails(@RequestBody Customer customer);
}
