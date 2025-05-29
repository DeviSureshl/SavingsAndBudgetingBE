package com.savings.SavingsAndBudgetingBE.repository;

import com.savings.SavingsAndBudgetingBE.model.SavingsAccounts;
import com.savings.SavingsAndBudgetingBE.model.Transaction;
import com.savings.SavingsAndBudgetingBE.utils.AccountNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class SavingsAccountsRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<SavingsAccounts> getSavingsAccountsByUserId(UUID userId) {
        String sql = "SELECT * FROM savings_accounts where user_id = ?";
        return jdbcTemplate.query(
                sql,new Object[]{userId},
                new BeanPropertyRowMapper<>(SavingsAccounts.class)
        );
    }

    public int createSavingsAccount(SavingsAccounts savingsAccounts) {
        savingsAccounts.setSavingsAccountNumber(AccountNumberGenerator.generateAccountNumber("SAV"));
        String sql = "insert into savings_accounts values (?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,savingsAccounts.getSavingsAccountNumber(),
                savingsAccounts.getUserId(),
                savingsAccounts.getTargetAmount(),
                savingsAccounts.getCurrentAmount(),
                savingsAccounts.getTargetDate(),
                savingsAccounts.getGoalName());

    }
}
