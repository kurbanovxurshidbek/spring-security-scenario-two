package com.springsecurity.scenariotwo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
class AuthDetailsService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = foundUserFromDb(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException(username);
    }

    private User foundUserFromDb(String username) {
        Map<String, String> users = new HashMap<>();
        users.put("khurshid", passwordEncoder.encode("123qwe"));
        users.put("begzod", passwordEncoder.encode("123qwe"));
        if (users.containsKey(username))
            return new User(username, users.get(username), new ArrayList<>());
        return null;
    }
}