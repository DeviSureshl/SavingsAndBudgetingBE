package com.savings.SavingsAndBudgetingBE.repository;


import com.savings.SavingsAndBudgetingBE.model.SavingsAccountTransaction;
import com.savings.SavingsAndBudgetingBE.model.SavingsAccounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class SavingsAccountTransactionsRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int createSavingsTransaction(UUID userId, long transactionAmount, String savingsAccountNumber, String accountNumber, Date transactionDate) {
        String sql = "INSERT INTO savings_transactions (transaction_id, user_id, savings_account_number, account_number, transaction_amount, transaction_date) " +
                "VALUES (uuid_generate_v4(), ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,userId,savingsAccountNumber,accountNumber,transactionAmount,transactionDate);

    }

    public int updateSavingsAccountBalance(String savingsAccountNumber, long transactionAmount) {
        /*String balanceQuery = "select * from savings_accounts where savings_account_number= ? ";
        SavingsAccounts savingsAccounts = jdbcTemplate.queryForObject(balanceQuery,
                new Object[]{savingsAccountNumber},
                SavingsAccounts.class
        );
        int resp = 0;
        long currentAmount = savingsAccounts.getCurrentAmount() + transactionAmount;
        long targetAmount = savingsAccounts.getTargetAmount();
        if(currentAmount> targetAmount){
            return resp;
        }else {
            String updateBalanceQuery = "update savings_accounts set current_amount= current_amount + ? where savings_account_number = ?";
            resp = 1;
             jdbcTemplate.update(updateBalanceQuery, transactionAmount,
                    savingsAccountNumber);
             return resp;
        }*/
        String updateBalanceQuery = "update savings_accounts set current_amount= current_amount + ? where savings_account_number = ?";
        return jdbcTemplate.update(updateBalanceQuery, transactionAmount,
                savingsAccountNumber);

    }

    public List<SavingsAccountTransaction> getSavingsAccountTransaction(String savingsAccountNumber) {
        String sql = "SELECT * FROM savings_transactions where savings_account_number =?";
        return jdbcTemplate.query(
                sql,new Object[]{savingsAccountNumber},
                new BeanPropertyRowMapper<>(SavingsAccountTransaction.class)
        );
    }
}
