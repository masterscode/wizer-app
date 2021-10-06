package com.library.services;

import com.library.payloads.requests.LoginRequest;
import com.library.payloads.requests.UserRegistrationRequest;
import com.library.payloads.response.LoginResponse;
import com.library.payloads.response.UserRegistrationResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserRegistrationResponse registerUser(UserRegistrationRequest request);

    LoginResponse loginUser(LoginRequest request);
}
