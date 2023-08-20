package com.interstRateService;

import com.interstRateService.model.Loan;
import com.interstRateService.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final LoanRepository loanRepository;

    @Autowired
    public DataInitializer(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (loanRepository.count() == 0) {

            Loan studentLoan = new Loan();
            studentLoan.setLoanType("Student Loan");
            studentLoan.setLoanRate(5.0); // Set the appropriate rate
            loanRepository.save(studentLoan);

            Loan educationLoan = new Loan();
            educationLoan.setLoanType("Education Loan");
            educationLoan.setLoanRate(4.5); // Set the appropriate rate
            loanRepository.save(educationLoan);


        }
    }
}
