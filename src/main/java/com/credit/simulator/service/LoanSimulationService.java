package com.credit.simulator.service;

import com.credit.simulator.dto.request.LoanSimulationRequest;
import com.credit.simulator.dto.response.LoanSimulationResponse;

public interface LoanSimulationService {
    LoanSimulationResponse simulateLoan(LoanSimulationRequest request);
}
