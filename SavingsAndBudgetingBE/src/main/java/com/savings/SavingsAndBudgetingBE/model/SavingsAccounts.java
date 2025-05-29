package com.savings.SavingsAndBudgetingBE.model;

import java.util.Date;
import java.util.UUID;

public class SavingsAccounts {
    private String savingsAccountNumber;
    private UUID userId;
    private long targetAmount;
    private long currentAmount;
    private Date targetDate;
    private String goalName;

    public SavingsAccounts() {
    }

    public SavingsAccounts(String savingsAccountNumber, UUID userId, long targetAmount, long currentAmount, Date targetDate, String goalName) {
        this.savingsAccountNumber = savingsAccountNumber;
        this.userId = userId;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.targetDate = targetDate;
        this.goalName = goalName;
    }

    public String getSavingsAccountNumber() {
        return savingsAccountNumber;
    }

    public void setSavingsAccountNumber(String savingsAccountNumber) {
        this.savingsAccountNumber = savingsAccountNumber;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public long getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(long targetAmount) {
        this.targetAmount = targetAmount;
    }

    public long getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(long currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }
}
