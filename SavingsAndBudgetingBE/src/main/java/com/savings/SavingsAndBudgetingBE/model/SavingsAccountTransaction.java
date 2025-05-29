package com.savings.SavingsAndBudgetingBE.model;

import java.util.Date;
import java.util.UUID;

public class SavingsAccountTransaction {
    private UUID transactionId;
    private UUID userId;
    private String savingsAccountNumber;
    private String accountNumber;
    private long transactionAmount;
    private Date transactionDate;

    public SavingsAccountTransaction() {
    }

    public SavingsAccountTransaction(UUID transactionId, UUID userId, String savingsAccountNumber, String accountNumber, long transactionAmount,Date transactionDate) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.savingsAccountNumber = savingsAccountNumber;
        this.accountNumber = accountNumber;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getSavingsAccountNumber() {
        return savingsAccountNumber;
    }

    public void setSavingsAccountNumber(String savingsAccountNumber) {
        this.savingsAccountNumber = savingsAccountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
