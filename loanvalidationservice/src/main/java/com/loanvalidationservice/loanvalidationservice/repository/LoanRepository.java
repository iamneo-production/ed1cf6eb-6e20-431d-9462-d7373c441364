package com.loanValidationService.repository;

import com.loanValidationService.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<CustomerDetails,Long> {
    CustomerDetails findByAccountnumber(int userid);
}
