package com.credit.simulator.dto.request;

import java.time.LocalDate;

public class LoanSimulationRequest {
    private Double loanAmount;
    private LocalDate birthDate;
    private int months;

    public Double getLoanAmount()
    {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount)
    {
        this.loanAmount = loanAmount;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }

    public int getMonths()
    {
        return months;
    }

    public void setMonths(int months)
    {
        this.months = months;
    }
}