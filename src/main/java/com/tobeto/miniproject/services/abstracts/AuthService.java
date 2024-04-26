package com.tobeto.miniproject.services.abstracts;

import com.tobeto.miniproject.services.dtos.requests.LoginRequest;
import com.tobeto.miniproject.services.dtos.requests.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest request);
    String login(LoginRequest request);
}
