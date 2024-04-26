package com.tobeto.miniproject.services.concretes;

import com.tobeto.miniproject.core.services.JwtService;
import com.tobeto.miniproject.core.utils.exceptionhandling.types.BusinessException;
import com.tobeto.miniproject.entities.User;
import com.tobeto.miniproject.repositories.UserRepository;
import com.tobeto.miniproject.services.abstracts.AuthService;
import com.tobeto.miniproject.services.dtos.requests.LoginRequest;
import com.tobeto.miniproject.services.dtos.requests.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;


    @Override
    public void register(RegisterRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setEmail(request.getEmail());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
    }

    @Override
    public String login(LoginRequest request) {
        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new BusinessException("E-posta ya da şifre yanlış."));

        Authentication authentication =
                authenticationManager
                        .authenticate(
                                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
                        );

        if(!authentication.isAuthenticated())
            throw new BusinessException("E-posta ya da şifre yanlış.");

        // TODO: JWT Oluştur ve kullanıcıya ver.
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("UserId",user.getId());
        return jwtService.generateToken(user.getUsername(), extraClaims);
    }
}
