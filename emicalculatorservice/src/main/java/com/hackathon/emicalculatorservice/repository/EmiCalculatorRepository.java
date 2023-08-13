package com.hackathon.emicalculatorservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.model.LoanDetails;

@Repository
public interface EmiCalculatorRepository extends JpaRepository<LoanDetails, Integer>{

}
