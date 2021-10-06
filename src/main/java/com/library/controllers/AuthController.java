package com.library.controllers;

import com.library.payloads.requests.LoginRequest;
import com.library.payloads.requests.UserRegistrationRequest;
import com.library.payloads.response.LoginResponse;
import com.library.payloads.response.UserRegistrationResponse;
import com.library.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> doLogin(@Valid @RequestBody LoginRequest request) {

        return ResponseEntity.ok(
                userService.loginUser(request)
        );
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponse> doRegister(@Valid @RequestBody UserRegistrationRequest request) {
        return ResponseEntity.ok(
                userService.registerUser(request)
        );
    }
}
