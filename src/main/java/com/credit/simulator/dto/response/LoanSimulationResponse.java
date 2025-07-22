package com.credit.simulator.dto.response;

public class LoanSimulationResponse {
    private Double totalAmount;
    private Double monthlyInstallment;
    private Double totalInterest;

    public LoanSimulationResponse(Double totalAmount, Double monthlyInstallment, Double totalInterest)
    {
        this.totalAmount = totalAmount;
        this.monthlyInstallment = monthlyInstallment;
        this.totalInterest = totalInterest;
    }

    public Double getTotalAmount()
    {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public Double getMonthlyInstallment()
    {
        return monthlyInstallment;
    }

    public void setMonthlyInstallment(Double monthlyInstallment)
    {
        this.monthlyInstallment = monthlyInstallment;
    }

    public Double getTotalInterest()
    {
        return totalInterest;
    }

    public void setTotalInterest(Double totalInterest)
    {
        this.totalInterest = totalInterest;
    }
}

