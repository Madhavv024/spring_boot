package com.example.controllers;

import com.example.config.JwtUtils;
import com.example.dao.UserDao;
import com.example.dto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtils jwtUtils;


    @GetMapping("/google")
    public String welcme(){
        return "Welcome to Google!";
    }
    @GetMapping("/hey")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/user")
    public Principal user(Principal principal){
        System.out.println("Username is -- "+principal.getName());
        return principal;
    }
    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request) {
        System.out.println("Authentication request: " + request);

        UserDetails userDetails = userDao.findUserByEmail(request.getEmail());
        if (userDetails != null && passwordAuthentication(request.getPassword(), userDetails.getPassword())) {
            return ResponseEntity.ok(jwtUtils.generateToken(userDetails));
        } else {
            return ResponseEntity.status(400).body("Authentication failed, Incorrect Password");
        }
    }

    public static boolean passwordAuthentication(String password, String dbPassword)
    {
        return password.equals(dbPassword);
    }
}
