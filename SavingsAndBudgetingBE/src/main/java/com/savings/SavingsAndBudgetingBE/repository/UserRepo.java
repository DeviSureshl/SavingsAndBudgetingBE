package com.savings.SavingsAndBudgetingBE.repository;

import com.savings.SavingsAndBudgetingBE.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM users where is_admin=false",
                new BeanPropertyRowMapper<>(User.class));
    }

    public Optional<User> getUserById(UUID userId) {
        String sql = "SELECT * FROM users where user_id =?";
        List<User> users = jdbcTemplate.query(
                sql,
                new Object[]{userId},
                new BeanPropertyRowMapper<>(User.class)
        );
        return users.stream().findFirst();
    }

    public User authenticateUser(String emailId, String password) {
        String sql = "SELECT * FROM users where email =? and password=?";
        return jdbcTemplate.queryForObject(
                sql, new Object[]{emailId,password},
                new BeanPropertyRowMapper<>(User.class)
        );
    }

    public int saveNewUser(User user) {
        String sql = "insert into users values (uuid_generate_v4(),?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,user.getFirstName(),user.getLastName(),user.getPassword(),user.getDateOfBirth(),user.getGender(),user.getEmail(),false);
    }

    public int deleteUser(UUID userId) {
        String sql = "delete from users where user_id=?";
        return jdbcTemplate.update(sql, new Object[]{userId});
    }
}
