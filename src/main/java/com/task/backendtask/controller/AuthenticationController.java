package com.task.backendtask.controller;

import com.task.backendtask.dto.AuthenticationResponse;
import com.task.backendtask.dto.UserRegistrationDTO;
import com.task.backendtask.entity.User;
import com.task.backendtask.service.implementation.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthenticationController {


    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    // handle registration
    @PostMapping("/registration")
    public ResponseEntity<AuthenticationResponse> registerUser(@Valid @RequestBody UserRegistrationDTO user) {
        return ResponseEntity.ok(authenticationService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(authenticationService.authenticate(user));
    }



}
