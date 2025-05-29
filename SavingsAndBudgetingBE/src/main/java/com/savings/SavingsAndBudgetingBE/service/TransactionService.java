package com.savings.SavingsAndBudgetingBE.service;


import com.savings.SavingsAndBudgetingBE.model.Transaction;
import com.savings.SavingsAndBudgetingBE.repository.AccountsRepo;
import com.savings.SavingsAndBudgetingBE.repository.SavingsAccountTransactionsRepo;
import com.savings.SavingsAndBudgetingBE.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class TransactionService {
    @Autowired
    private TransactionRepo repository;

    @Autowired
    private AccountsRepo accountsRepo;
    @Autowired
    private SavingsAccountTransactionsRepo savingsAccountTransactionsRepo;

    public List<Transaction> getTransactionsByUserId(UUID userId) {
        return repository.getTransactionsByUserId(userId);
    }

    public int createTransaction(Transaction transaction) {
        int  response =  accountsRepo.updateAccountBalance( transaction.getTransactionType(),transaction.getAccountNumber(),transaction.getTransactionAmount());


        if(response!=0){
            response = repository.createTransaction(transaction.getUserId(),
                    transaction.getAccountNumber(),
                    transaction.getTransactionType(),
                    transaction.getTransactionAmount(),
                    transaction.getTransactionDate());
            if(transaction.getTransactionType().equals("INVESTMENT")){
                int savingsResp = savingsAccountTransactionsRepo.createSavingsTransaction(transaction.getUserId(), transaction.getTransactionAmount(),transaction.getSavingsAccountNumber(),transaction.getAccountNumber(),transaction.getTransactionDate());
                if(savingsResp!=0){
                    savingsAccountTransactionsRepo.updateSavingsAccountBalance( transaction.getSavingsAccountNumber(),transaction.getTransactionAmount());
                }else{
                    throw new RuntimeException();
                }
            }

        }
        return response;
    }
}
