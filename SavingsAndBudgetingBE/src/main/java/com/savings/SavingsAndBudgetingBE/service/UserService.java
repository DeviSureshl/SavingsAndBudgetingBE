package com.savings.SavingsAndBudgetingBE.service;

import com.savings.SavingsAndBudgetingBE.exceptions.UserNotFoundException;
import com.savings.SavingsAndBudgetingBE.model.User;
import com.savings.SavingsAndBudgetingBE.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepo repository;
    public List<User> getUserList() {
        return repository.getAllUsers();
    }


    public User getUserById(UUID userId) {
        return repository.getUserById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));
    }

    public User authenticateUser(String emailId, String password) {
        return repository.authenticateUser(emailId, password);
    }

    public int saveNewUser(User user) {
        return repository.saveNewUser(user);
    }

    public int deleteUser(UUID userId) {
        return repository.deleteUser(userId);
    }
}
