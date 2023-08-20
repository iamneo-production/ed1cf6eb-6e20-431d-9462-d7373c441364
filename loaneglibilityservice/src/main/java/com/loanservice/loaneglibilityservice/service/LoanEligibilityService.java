package com.loanservice.loaneglibilityservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loanservice.loaneglibilityservice.entity.Customer;
import com.loanservice.loaneglibilityservice.repository.CustomerRepository;


//import com.loanservice.repository.CustomerRepository;

@Service
public class LoanEligibilityService {

	@Autowired
	CustomerRepository customerRepository;
    public boolean checkEligibility(double loanAmount, double income, int creditScore) {
        
        
        if (income >=30000 && creditScore >= 700 && loanAmount <= (income * 5)) {
        	
     	 Customer customer = new Customer("John", "Doe", income, creditScore);
     	 customerRepository.save(customer);

            return true; // Customer is eligible
        } else {
            return false; // Customer is not eligible
        }
    }
}
