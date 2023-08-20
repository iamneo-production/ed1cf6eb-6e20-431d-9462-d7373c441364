package com.interstRateService.controller;

import com.interstRateService.dto.InterestRateResponse;
import com.interstRateService.service.InterestRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interest")
public class InterestController {

    @Autowired
    public InterestRateService interestRateService;
    @GetMapping("/rate/{loanType}")
    public InterestRateResponse requestRate(@PathVariable String loanType){


        return interestRateService.getLoanRateByType(loanType);
    }
}
