package com.savings.SavingsAndBudgetingBE.model;

import java.util.Date;
import java.util.UUID;

public class Transaction {
    private UUID transactionId;
    private UUID userId;
    private String accountNumber;
    private String transactionType;
    private long transactionAmount;
    private Date transactionDate;
    private String savingsAccountNumber;

    public Transaction() {
    }

    public Transaction(UUID transactionId, UUID userId, String accountNumber, String transactionType, long transactionAmount,Date transactionDate, String savingsAccountNumber) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionDate =transactionDate;
        this.savingsAccountNumber = savingsAccountNumber;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
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

    public String getSavingsAccountNumber() {
        return savingsAccountNumber;
    }

    public void setSavingsAccountNumber(String savingsAccountNumber) {
        this.savingsAccountNumber = savingsAccountNumber;
    }
}
