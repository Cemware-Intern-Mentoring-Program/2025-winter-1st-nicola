package com.cemware.nicola.controller;

import com.cemware.nicola.domain.user.User;
import com.cemware.nicola.dto.LoginDto;
import com.cemware.nicola.dto.UserCreateDto;
import com.cemware.nicola.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) { this.userService = userService; }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(UserCreateDto dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

//    @GetMapping("/login")
//    public ResponseEntity<User> login(LoginDto dto) {
//        return ResponseEntity.ok();
//    }

}
