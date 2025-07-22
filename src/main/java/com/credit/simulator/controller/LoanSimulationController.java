package com.credit.simulator.controller;

import com.credit.simulator.dto.request.LoanSimulationRequest;
import com.credit.simulator.dto.response.LoanSimulationResponse;
import com.credit.simulator.service.LoanSimulationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simulations")
public class LoanSimulationController {

    private final LoanSimulationService service;

    public LoanSimulationController(LoanSimulationService service)
    {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LoanSimulationResponse> simulate(@RequestBody LoanSimulationRequest request)
    {
        return ResponseEntity.ok(service.simulateLoan(request));
    }
}