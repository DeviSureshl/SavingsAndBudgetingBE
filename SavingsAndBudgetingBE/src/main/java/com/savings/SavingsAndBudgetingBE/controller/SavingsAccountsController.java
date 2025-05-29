package com.savings.SavingsAndBudgetingBE.controller;

import com.savings.SavingsAndBudgetingBE.dto.ApiResponse;
import com.savings.SavingsAndBudgetingBE.model.SavingsAccounts;
import com.savings.SavingsAndBudgetingBE.model.Transaction;
import com.savings.SavingsAndBudgetingBE.service.SavingsAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/savingsAccounts")
public class SavingsAccountsController {
    public SavingsAccountsService savingsAccountsService;
    @Autowired
    public SavingsAccountsController(SavingsAccountsService savingsAccountsService){
        this.savingsAccountsService=savingsAccountsService;
    }
    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<List<SavingsAccounts>>> getSavingsAccountsByUserId(@PathVariable("userId") UUID userId) {
        List<SavingsAccounts> savingsAccounts = savingsAccountsService.getSavingsAccountsByUserId(userId);
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(),savingsAccounts ), HttpStatus.OK);
    }

    @PostMapping("/create-savings")
    public ResponseEntity<ApiResponse<String>> createSavingsAccount(@RequestBody SavingsAccounts savingsAccounts) {
        int response = savingsAccountsService.createSavingsAccount(savingsAccounts);

        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.CREATED.value(), "Savings Account successfully created"), HttpStatus.CREATED);
    }
}
