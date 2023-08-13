package com.hackathon.emicalculatorservice.service;

@Service
public class EmiCalculatorService {

	@Autowired
	public EmiCalculatorRepository emirepo;
	

	public LoanDetails savedetails(LoanDetails loanDetails) {
		return emirepo.save(loanDetails);
		
	}

    public List<LoanDetails> getDetails(){
		
		return (List<LoanDetails>)emirepo.findAll();
	}

    public double calculateEMI(LoanDetails loanDetails) {
        double principal = loanDetails.getLoanAmount();
        double rate = loanDetails.getInterestRate() / 12 / 100;
        int tenure = loanDetails.getLoanTenure();
        

        double emi = (principal * rate * Math.pow(1 + rate, tenure)) / (Math.pow(1 + rate, tenure) - 1);
        return emi;
    }
}
