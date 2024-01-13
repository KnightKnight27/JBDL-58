package com.example.controller;

import com.example.Utils;
import com.example.dto.CreateUserRequest;
import com.example.dto.GetUserResponse;
import com.example.model.User;
import com.example.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public void createUser(@RequestBody @Valid CreateUserRequest userRequest) throws JsonProcessingException {
        userService.create(Utils.convertUserCreateRequest(userRequest));
    }

    @GetMapping("/user/{userId}")
    public GetUserResponse getUser(@PathVariable("userId") int userId) throws Exception {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user = userService.get(user.getId());
        return Utils.convertToUserResponse(user);
    }
}