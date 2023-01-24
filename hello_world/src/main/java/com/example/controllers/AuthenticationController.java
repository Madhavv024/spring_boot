package com.example.controllers;

import com.example.config.JwtUtils;
import com.example.dao.UserDao;
import com.example.dto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtils jwtUtils;

    @GetMapping("/hey")
    public String helloWorld() {
        return "Hello world";
    }


    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
        @RequestBody AuthenticationRequest request) {
        System.out.println("Authentication request: " + request);
        System.out.println("hello");

//        authenticationManager.authenticate(
//            new UsernamePasswordAuthenticationToken(
//                request.getEmail(),
//                request.getPassword()
//            )
//        );
        UserDetails userDetails = userDao.findUserByEmail(request.getEmail());
        System.out.println("Username is--" + userDetails.getUsername());
        if (userDetails != null) {
            return ResponseEntity.ok(jwtUtils.generateToken(userDetails));
        } else {
            return ResponseEntity.status(400).body("Authentication failed");
        }
    }
}
