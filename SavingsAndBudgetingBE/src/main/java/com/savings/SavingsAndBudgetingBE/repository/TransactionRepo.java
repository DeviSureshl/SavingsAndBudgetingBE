package com.savings.SavingsAndBudgetingBE.repository;

import com.savings.SavingsAndBudgetingBE.model.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Repository
public class TransactionRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Transaction> getTransactionsByUserId(UUID userId) {
        String sql = "SELECT * FROM transactions where user_id = ?";
        return jdbcTemplate.query(
                sql,new Object[]{userId},
                new BeanPropertyRowMapper<>(Transaction.class)
        );
    }

    public int createTransaction(UUID userId, String accountNumber, String transactionType, long transactionAmount, Date transactionDate) {
        String sql = "insert into transactions values (uuid_generate_v4(),?,?,?,?,?)";
        return jdbcTemplate.update(sql,userId,accountNumber,transactionType,transactionAmount,transactionDate);
    }
}
