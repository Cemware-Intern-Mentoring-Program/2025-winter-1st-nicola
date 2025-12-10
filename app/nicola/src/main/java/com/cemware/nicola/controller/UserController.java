package com.cemware.nicola.controller;

import com.cemware.nicola.domain.group.Group;
import com.cemware.nicola.domain.user.User;
import com.cemware.nicola.dto.UserCreateDto;
import com.cemware.nicola.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


//    @PostMapping
//    public ResponseEntity<User> create(@RequestBody UserCreateDto dto) {
//        return ResponseEntity.ok(userService.createUser(dto));
//    }


    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UserCreateDto dto) {
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }


    @GetMapping("/{id}/groups")
    public ResponseEntity<Object> getGroups(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserGroups(id));
    }
}
