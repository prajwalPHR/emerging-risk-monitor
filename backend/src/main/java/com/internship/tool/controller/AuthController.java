package com.internship.tool.controller;

import com.internship.tool.config.JwtUtil;
import com.internship.tool.dto.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        if ("admin".equals(request.username) &&
                "admin".equals(request.password)) {

            return jwtUtil.generateToken(request.username);
        }

        throw new RuntimeException("Invalid credentials");
    }
}