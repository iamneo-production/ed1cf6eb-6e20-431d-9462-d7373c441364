package com.loanValidationService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.loanValidationService.model.CustomerDetails;
import com.loanValidationService.repository.LoanRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final LoanRepository customerRepository;

    public DataInitializer(LoanRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() == 0) {
            CustomerDetails customer1 = new CustomerDetails(123456, 60000, 0, 800, 5000);
            CustomerDetails customer2 = new CustomerDetails(789012, 150000, 0, 600, 8000);

            customerRepository.save(customer1);
            customerRepository.save(customer2);
        }

    }
}
