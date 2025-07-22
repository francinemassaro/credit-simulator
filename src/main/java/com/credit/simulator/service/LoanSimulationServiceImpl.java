package com.credit.simulator.service;

import com.credit.simulator.dto.request.LoanSimulationRequest;
import com.credit.simulator.dto.response.LoanSimulationResponse;
import com.credit.simulator.util.TaxaFaixaEtariaEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class LoanSimulationServiceImpl implements LoanSimulationService {
    private static final Logger log = LoggerFactory.getLogger(LoanSimulationServiceImpl.class);

    @Override
    public LoanSimulationResponse simulateLoan(LoanSimulationRequest request)
    {
        log.info("Iniciando calculo de simulação de empréstimo.");
        int age = Period.between(request.getBirthDate(), LocalDate.now())
                .getYears();
        double annualRate = TaxaFaixaEtariaEnum.getRateByAgeAsDouble(age);
        double monthlyRate = annualRate / 12;

        double loanAmount = request.getLoanAmount()
                .doubleValue();
        int months = request.getMonths();

        double pmt = pmt(loanAmount, monthlyRate, months);
        double totalToPay = pmt * months;
        double interest = totalToPay - loanAmount;

        return new LoanSimulationResponse(
                round(totalToPay),
                round(pmt),
                round(interest)
        );
    }

    public double pmt(double pv, double monthlyRate, int months)
    {
        log.info("Utilizando fórmula de cálculo de parcelas fixas");
        double denominator = 1 - Math.pow(1 + monthlyRate, -months);
        return (pv * monthlyRate) / denominator;
    }

    private double round(double value)
    {
        log.info("Atualizando valor para duas casas decimais");
        return Math.round(value * 100.0) / 100.0;
    }
}
