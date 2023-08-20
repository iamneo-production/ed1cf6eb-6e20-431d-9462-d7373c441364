package com.loanservice.loaneglibilityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loanservice.loaneglibilityservice.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // You can define additional methods here if needed
}

