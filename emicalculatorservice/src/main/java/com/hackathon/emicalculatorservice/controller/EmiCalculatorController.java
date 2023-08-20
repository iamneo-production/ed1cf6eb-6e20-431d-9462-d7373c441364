package com.hackathon.emicalculatorservice.controller;

import com.emiCalculatorService.dto.NotificationResponce;
import com.emiCalculatorService.model.LoanDetails;
import com.emiCalculatorService.service.EmiCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmiCalculatorController {

    @Autowired
    public EmiCalculatorService emiService;

    @PostMapping("/calculate-emi")
    public ResponseEntity<NotificationResponce> calculateEMI(@RequestBody LoanDetails loanDetails) {

        NotificationResponce notificationResponce = emiService.calculateEMI(loanDetails);
        return ResponseEntity.ok(notificationResponce);
    }

    @GetMapping("/getDetails")
    public List<LoanDetails> getAllDetails(){
        return emiService.getDetails();

    }

    @PostMapping("/addLoanDetails")
    public LoanDetails postDetails(@RequestBody LoanDetails loandetail) {

        return emiService.savedetails(loandetail);
    }

}