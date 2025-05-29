package com.savings.SavingsAndBudgetingBE.controller;

import com.savings.SavingsAndBudgetingBE.dto.ApiResponse;
import com.savings.SavingsAndBudgetingBE.model.Accounts;
import com.savings.SavingsAndBudgetingBE.model.Transaction;
import com.savings.SavingsAndBudgetingBE.model.User;
import com.savings.SavingsAndBudgetingBE.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/accounts")
public class AccountsController {
    private AccountsService accountsService;

    @Autowired
    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }
    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<List<Accounts>>> getAccountsByUserId(@PathVariable("userId") UUID userId) {
        List<Accounts> transactions = accountsService.getAccountsByUserId(userId);
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(),transactions ), HttpStatus.OK);
    }
    @PostMapping("/create-account")
    public ResponseEntity<ApiResponse<String>> createAccount(@RequestBody Accounts account) {
        int accountResponse = accountsService.createAccount(account);

        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.CREATED.value(), "account successfully created"), HttpStatus.CREATED);
    }
}
