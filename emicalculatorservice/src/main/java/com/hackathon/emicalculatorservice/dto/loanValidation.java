package com.hackathon.emicalculatorservice.dto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class loanValidation {


    private int accountNumber;
    private double loanAmount;
    private int loanTenure;
}
