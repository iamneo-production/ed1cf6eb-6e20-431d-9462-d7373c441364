package com.interstRateService.service;

import com.interstRateService.dto.InterestRateResponse;
import com.interstRateService.model.Loan;
import com.interstRateService.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestRateService {
    @Autowired
    public  LoanRepository loanRepository;
    public InterestRateResponse getLoanRateByType(String loanType) {
        Loan loan = loanRepository.findByLoanType(loanType);

        if (loan != null) {
            InterestRateResponse response = new InterestRateResponse();
            response.setLoanRate(loan.getLoanRate());
            return response;
        } else {

            return null;
        }
    }

}
