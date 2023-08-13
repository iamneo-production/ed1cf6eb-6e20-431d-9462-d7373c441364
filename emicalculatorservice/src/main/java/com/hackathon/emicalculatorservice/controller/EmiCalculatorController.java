package com.hackathon.emicalculatorservice.controller;

@RestController
public class EmiCalculatorController {

	@Autowired
	public EmiCalculatorService emiService;

    @PostMapping("/calculate-emi")
    public ResponseEntity<Double> calculateEMI(@RequestBody LoanDetails loanDetails) {
    	
        double emi = emiCalculatorService.calculateEMI(loanDetails);
        return ResponseEntity.ok(emi);
    }
   
    @GetMapping("/getDetails")
    public List<LoanDetails> getAllDetails(){
		return emiCalculatorService.getDetails();
    	
    }

	@PostMapping("/addLoanDetails")
	public LoanDetails postDetails(@RequestBody LoanDetails loandetail) {
		
		return emiService.savedetails(loandetail);
	}

}
