package com.bangvan.demologin.controller;

import com.bangvan.demologin.dto.request.ApiResponse;
import com.bangvan.demologin.dto.request.UserCreationRequest;
import com.bangvan.demologin.dto.request.UserUdateRequest;
import com.bangvan.demologin.dto.respond.UserRespond;
import com.bangvan.demologin.entity.User;
import com.bangvan.demologin.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/user")
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        apiResponse.setCode(1000);
        apiResponse.setMessage("Create user success");
        return apiResponse;
    }

    @GetMapping("/users")
    public ApiResponse<List<UserRespond>> getAllUsers() {
        ApiResponse<List<UserRespond>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.getAllUsers());
        apiResponse.setCode(1000);
        apiResponse.setMessage("Get all users success");
        return apiResponse;
    }

    @GetMapping("/user/{userId}")
    public UserRespond getUserById(@PathVariable Long userId) {
        return modelMapper.map(userService.getUserById(userId),UserRespond.class);

    }

    @PutMapping("/user/{userId}")
    public User updateUser(@RequestBody UserUdateRequest request, @PathVariable Long userId) {
        return userService.updateUser(request, userId);
    }

    @DeleteMapping("/user/{userId}")
    public User deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}
