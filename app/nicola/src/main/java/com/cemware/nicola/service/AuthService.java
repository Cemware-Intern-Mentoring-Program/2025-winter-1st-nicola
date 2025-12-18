package com.cemware.nicola.service;

import com.cemware.nicola.domain.user.User;
import com.cemware.nicola.dto.UserCreateDto;
import com.cemware.nicola.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User signup(UserCreateDto dto){
        User user = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();

        return userRepository.save(user);
    }
//    public User login(LoginRequestDto dto) {
//
//        return ;
//    }
}
