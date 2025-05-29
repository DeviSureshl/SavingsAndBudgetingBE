package com.savings.SavingsAndBudgetingBE.controller;

import com.savings.SavingsAndBudgetingBE.dto.ApiResponse;
import com.savings.SavingsAndBudgetingBE.model.SavingsAccountTransaction;
import com.savings.SavingsAndBudgetingBE.model.Transaction;
import com.savings.SavingsAndBudgetingBE.service.SavingsAccountTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/savingsTransactions")
public class SavingsAccountTransactionsController {
    private SavingsAccountTransactionsService savingsAccountTransactionsService;

    @Autowired
    public SavingsAccountTransactionsController(SavingsAccountTransactionsService savingsAccountTransactionsService) {
        this.savingsAccountTransactionsService = savingsAccountTransactionsService;
    }

    @GetMapping("/{savingsAccountNumber}")
    public ResponseEntity<ApiResponse<List<SavingsAccountTransaction>>> getSavingsAccountTransaction(@PathVariable("savingsAccountNumber") String savingsAccountNumber) {
        List<SavingsAccountTransaction> savingsTransactions = savingsAccountTransactionsService.getSavingsAccountTransaction(savingsAccountNumber);
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(),savingsTransactions ), HttpStatus.OK);
    }
}
