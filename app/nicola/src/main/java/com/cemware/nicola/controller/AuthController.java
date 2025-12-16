package com.cemware.nicola.controller;

import com.cemware.nicola.domain.user.User;
import com.cemware.nicola.dto.UserCreateDto;
import com.cemware.nicola.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody UserCreateDto dto) {
        return ResponseEntity.ok(authService.signup(dto));
    }
}
