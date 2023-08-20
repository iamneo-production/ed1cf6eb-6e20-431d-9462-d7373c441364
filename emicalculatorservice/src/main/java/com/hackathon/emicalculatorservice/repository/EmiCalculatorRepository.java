package com.emiCalculatorService.repository;

import com.emiCalculatorService.model.LoanDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmiCalculatorRepository extends JpaRepository<LoanDetails, Integer> {

}