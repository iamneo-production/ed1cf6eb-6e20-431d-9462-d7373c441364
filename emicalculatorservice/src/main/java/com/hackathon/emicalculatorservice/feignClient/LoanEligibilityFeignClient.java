package com.emiCalculatorService.feignClient;

import com.emiCalculatorService.dto.EligibilityResponse;
import com.emiCalculatorService.dto.LoanEligibilityRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="loan-eligibility-service",url = "http://localhost:8083/eligibility")
public interface LoanEligibilityFeignClient {
    @PostMapping("/check-loan-eligibility")
    public EligibilityResponse checkLoanEligibility(@RequestBody LoanEligibilityRequest request) ;
}
