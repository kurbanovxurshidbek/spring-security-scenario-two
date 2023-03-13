package com.springsecurity.scenariotwo.controller;

import com.springsecurity.scenariotwo.model.CustomResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HomeController {
    @GetMapping("/home")
    public CustomResponse home() {
        return CustomResponse.successMsg("Welcome to home");
    }
}
