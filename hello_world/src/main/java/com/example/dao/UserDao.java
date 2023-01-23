package com.example.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDao {
    private final static List<UserDetails> APPLICATION_USERS =
            Arrays.asList(
                    new User("ravi@decoverhq.com", "password",
                            Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))),
                    new User("ravitandon2@gmail.com", "password",
                            Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")))
            );
    public UserDetails findUserByEmail(String email) throws UsernameNotFoundException {
        return APPLICATION_USERS.stream()
                .filter(user -> user.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
