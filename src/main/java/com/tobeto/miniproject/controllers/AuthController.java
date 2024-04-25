package com.tobeto.miniproject.controllers;

import com.tobeto.miniproject.services.abstracts.AuthService;
import com.tobeto.miniproject.services.dtos.requests.LoginRequest;
import com.tobeto.miniproject.services.dtos.requests.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;


    @PostMapping("login")
    public String login(@RequestBody LoginRequest loginRequest)
    {
        authService.login(loginRequest);
        return "";
    }

    @PostMapping("register")
    public void register(@RequestBody RegisterRequest request) {
        authService.register(request);
    }
}
