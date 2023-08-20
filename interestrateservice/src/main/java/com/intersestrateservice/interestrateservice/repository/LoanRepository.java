package com.interstRateService.repository;

import com.interstRateService.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    Loan findByLoanType(String loanType);
}
