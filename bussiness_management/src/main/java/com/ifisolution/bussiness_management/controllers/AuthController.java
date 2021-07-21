//package com.ifisolution.bussiness_management.controllers;
//
//import com.ifisolution.bussiness_management.dto.AuthenticateResponse;
//import com.ifisolution.bussiness_management.dto.LoginRequest;
//import com.ifisolution.bussiness_management.dto.RegisterRequest;
//import com.ifisolution.bussiness_management.services.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//    @Autowired
//    private AuthService authService;
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> signup(@RequestBody RegisterRequest registerRequest) {
//        boolean result = authService.signup(registerRequest);
//        if (!result)
//            return new ResponseEntity<>("Username already exist", HttpStatus.BAD_REQUEST);
//
//        return new ResponseEntity<>("Successfully Register", HttpStatus.CREATED);
//
//    }
//
//    @PostMapping("/login")
//    public AuthenticateResponse login(@RequestBody LoginRequest loginRequest) throws Exception {
//        return authService.login(loginRequest);
//    }
//}
