package com.hackathon.emicalculatorservice.model;


@Entity
@Table(name="loandetails")
public class LoanDetails {
	
	@Id
	@GeneratedValue
	private int accountNumber;
    private double loanAmount;
    private double interestRate;
    private int loanTenure;
	
    public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getLoanTenure() {
		return loanTenure;
	}
	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}
	
	public LoanDetails() {
		super();
	}
	
	@Override
	public String toString() {
		return "LoanDetails [accountNumber=" + accountNumber + ", loanAmount=" + loanAmount + ", interestRate="
				+ interestRate + ", loanTenure=" + loanTenure + "]";
	}
	
}
