package com.savings.SavingsAndBudgetingBE.controller;


import com.savings.SavingsAndBudgetingBE.dto.ApiResponse;
import com.savings.SavingsAndBudgetingBE.model.User;
import com.savings.SavingsAndBudgetingBE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        List<User>userList = userService.getUserList();
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(), userList ), HttpStatus.OK);
    }

    @PostMapping("/authenticate-user")
    public ResponseEntity<ApiResponse<User>> authenticate(@RequestBody User user) {
       User userResponse = userService.authenticateUser(user.getEmail(), user.getPassword());
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(), userResponse), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable("id") UUID userId) {
        User user = userService.getUserById(userId);
        if(user==null){
            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.NOT_FOUND.value(),"User not found"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(), user ), HttpStatus.OK);
    }

    @PostMapping("/register-user")
    public ResponseEntity<ApiResponse<String>> saveNewUser(@RequestBody User user) {
        int userResponse = userService.saveNewUser(user);
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.CREATED.value(), "user successfully added"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable("id") UUID userId) {
        int userResponse = userService.deleteUser(userId);
        if(userResponse == 1){
             return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(), "user deleted successfully"), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "user don't exist"), HttpStatus.NOT_FOUND);
        }
    }

}
