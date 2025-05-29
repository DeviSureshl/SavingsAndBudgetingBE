package com.savings.SavingsAndBudgetingBE.service;

import com.savings.SavingsAndBudgetingBE.model.SavingsAccounts;
import com.savings.SavingsAndBudgetingBE.repository.SavingsAccountsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SavingsAccountsService {

    @Autowired
    private SavingsAccountsRepo savingsAccountsRepo;

    public List<SavingsAccounts> getSavingsAccountsByUserId(UUID userId) {
        return savingsAccountsRepo.getSavingsAccountsByUserId(userId);
    }

    public int createSavingsAccount(SavingsAccounts savingsAccounts) {
        return savingsAccountsRepo.createSavingsAccount( savingsAccounts);

    }
}
