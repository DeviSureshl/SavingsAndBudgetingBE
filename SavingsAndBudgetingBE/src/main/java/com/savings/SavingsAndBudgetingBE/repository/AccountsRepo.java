package com.savings.SavingsAndBudgetingBE.repository;

import com.savings.SavingsAndBudgetingBE.exceptions.InsufficientBalanceException;
import com.savings.SavingsAndBudgetingBE.model.Accounts;
import com.savings.SavingsAndBudgetingBE.model.User;
import com.savings.SavingsAndBudgetingBE.utils.AccountNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class AccountsRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public List<Accounts> getAccountsByUserId(UUID userId) {
        String sql = "SELECT * FROM user_accounts where user_id = ?";
        return jdbcTemplate.query(
                sql,new Object[]{userId},
                new BeanPropertyRowMapper<>(Accounts.class)
        );
    }

    public Accounts createAccount(Accounts account) {
        account.setAccountNumber(AccountNumberGenerator.generateAccountNumber("ACC"));
        String sql = "insert into user_accounts values (?,?,?,?)";
        jdbcTemplate.update(sql,account.getAccountNumber(),
               account.getUserId(),
               account.getAccountType(),
                account.getBalance());
        String selectSql = "SELECT * FROM user_accounts WHERE account_number = ?";
        return jdbcTemplate.queryForObject(
                selectSql,
                new Object[]{account.getAccountNumber()},
                new BeanPropertyRowMapper<>(Accounts.class)
        );


    }

    public int updateAccountBalance(String transactionType, String accountNumber, long transactionAmount) {
        String balanceQuery = "select balance from user_accounts where account_number= ? ";
        long balance = jdbcTemplate.queryForObject(balanceQuery,
                new Object[]{accountNumber},
                Long.class
                );
        if(transactionType.equals("CREDIT BALANCE")){
            balance = balance+transactionAmount;
        }else{
            if(balance>transactionAmount){
                balance = balance-transactionAmount;
            }else{
                throw new InsufficientBalanceException("Insufficient balance");
            }

        }
        if(balance>0){
            String updateBalanceQuery = "update user_accounts set balance= ? where account_number = ?";
            return jdbcTemplate.update(updateBalanceQuery,balance,
                    accountNumber);
        }else{
            throw new InsufficientBalanceException("Insufficient balance");
        }

    }
}
