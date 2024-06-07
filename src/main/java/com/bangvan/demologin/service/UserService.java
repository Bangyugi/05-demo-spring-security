package com.bangvan.demologin.service;

import com.bangvan.demologin.dto.request.UserCreationRequest;
import com.bangvan.demologin.dto.request.UserUdateRequest;
import com.bangvan.demologin.dto.respond.UserRespond;
import com.bangvan.demologin.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(UserCreationRequest request);
    List<UserRespond> getAllUsers();
    UserRespond getUserById(Long id);
    User updateUser(UserUdateRequest userUdateRequest, Long id);
    User deleteUser(Long id);
}
