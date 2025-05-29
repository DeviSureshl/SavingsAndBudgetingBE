package com.savings.SavingsAndBudgetingBE.controller;

import com.savings.SavingsAndBudgetingBE.dto.ApiResponse;
import com.savings.SavingsAndBudgetingBE.model.Accounts;
import com.savings.SavingsAndBudgetingBE.model.Transaction;

import com.savings.SavingsAndBudgetingBE.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/transactions")
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<List<Transaction>>> getTransactionsByUserId(@PathVariable("userId") UUID userId) {
        List<Transaction> transactions = transactionService.getTransactionsByUserId(userId);
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(),transactions ), HttpStatus.OK);
    }

    @PostMapping("/create-transaction")
    public ResponseEntity<ApiResponse<String>> createTransaction(@RequestBody Transaction transaction) {
        int transactionResponse = transactionService.createTransaction(transaction);

        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.CREATED.value(), "transaction successfully created"), HttpStatus.CREATED);
    }
}
