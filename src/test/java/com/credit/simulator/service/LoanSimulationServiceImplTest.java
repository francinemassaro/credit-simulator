package com.credit.simulator.service;

import com.credit.simulator.dto.request.LoanSimulationRequest;
import com.credit.simulator.dto.response.LoanSimulationResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LoanSimulationServiceImplTest {
    private final LoanSimulationService service = new LoanSimulationServiceImpl();

    @Test
    public void testSimulacao_Cliente25Anos() {
        LoanSimulationRequest req = new LoanSimulationRequest();
        req.setLoanAmount(10000.0);
        req.setBirthDate(LocalDate.now().minusYears(25));
        req.setMonths(12);

        LoanSimulationResponse res = service.simulateLoan(req);

        assertNotNull(res);
        assertTrue(res.getMonthlyInstallment() > 0);
        assertTrue(res.getTotalInterest() > 0);
    }

    @Test
    public void testSimulacao_ClienteAcima60Anos() {
        LoanSimulationRequest req = new LoanSimulationRequest();
        req.setLoanAmount(20000.0);
        req.setBirthDate(LocalDate.now().minusYears(65));
        req.setMonths(24);

        LoanSimulationResponse res = service.simulateLoan(req);

        assertNotNull(res);
        assertEquals(24, Math.round(res.getTotalAmount() / res.getMonthlyInstallment()));
    }

    @Test
    public void testSimulacao_SemJurosZeroMeses() {
        LoanSimulationRequest req = new LoanSimulationRequest();
        req.setLoanAmount(5000.0);
        req.setBirthDate(LocalDate.now().minusYears(35));
        req.setMonths(1);

        LoanSimulationResponse res = service.simulateLoan(req);

        assertEquals(res.getMonthlyInstallment(), res.getTotalAmount());
    }
}