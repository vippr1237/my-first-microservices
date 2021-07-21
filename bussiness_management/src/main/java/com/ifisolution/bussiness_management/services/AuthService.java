//package com.ifisolution.bussiness_management.services;
//
//import com.ifisolution.bussiness_management.dto.AuthenticateResponse;
//import com.ifisolution.bussiness_management.dto.LoginRequest;
//import com.ifisolution.bussiness_management.dto.RegisterRequest;
//import com.ifisolution.bussiness_management.models.User;
//import com.ifisolution.bussiness_management.repositories.UserRepo;
//import com.ifisolution.bussiness_management.security.JwtProvider;
//import lombok.AllArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.time.Instant;
//
//@Service
//@AllArgsConstructor
//public class AuthService {
//    private final PasswordEncoder passwordEncoder;
//    private final UserRepo userRepo;
//    private final AuthenticationManager authenticationManager;
//    private final JwtProvider jwtProvider;
//
//    @Transactional
//    public boolean signup(RegisterRequest registerRequest) {
//        if (userRepo.existsByUsername(registerRequest.getUsername()))
//            return false;
//        User user = new User();
//        user.setUsername(registerRequest.getUsername());
//        user.setEmail(registerRequest.getEmail());
//        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
//        user.setCreateAt(Instant.now());
//
//        userRepo.save(user);
//        return true;
//    }
//
//    public AuthenticateResponse login(LoginRequest loginRequest) {
//        // authenticate nhơ object này của spring security
//        Authentication authenticate = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getUsername(), loginRequest.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authenticate);
//        String token = jwtProvider.generateToken(authenticate);
//        return new AuthenticateResponse(true, token);
//    }
//}
