package com.savings.SavingsAndBudgetingBE.service;

import com.savings.SavingsAndBudgetingBE.model.Accounts;
import com.savings.SavingsAndBudgetingBE.repository.AccountsRepo;
import com.savings.SavingsAndBudgetingBE.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AccountsService {
    @Autowired
    private AccountsRepo repository;
    @Autowired
    private TransactionRepo transRepo;

    public List<Accounts> getAccountsByUserId(UUID userId) {
        return repository.getAccountsByUserId(userId);
    }

    public int createAccount(Accounts account) {
        //createTransaction
        Accounts accounts = repository.createAccount(account);

        return transRepo.createTransaction(accounts.getUserId(),
                accounts.getAccountNumber(),
                "CREDIT BALANCE",
                accounts.getBalance(),new Date());
    }
}
