package com.savings.SavingsAndBudgetingBE.service;

import com.savings.SavingsAndBudgetingBE.model.SavingsAccountTransaction;
import com.savings.SavingsAndBudgetingBE.repository.SavingsAccountTransactionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SavingsAccountTransactionsService {

    @Autowired
    private SavingsAccountTransactionsRepo savingsAccountTransactionsRepo;

    public List<SavingsAccountTransaction> getSavingsAccountTransaction(String savingsAccountNumber) {
        return savingsAccountTransactionsRepo.getSavingsAccountTransaction(savingsAccountNumber);
    }

}
