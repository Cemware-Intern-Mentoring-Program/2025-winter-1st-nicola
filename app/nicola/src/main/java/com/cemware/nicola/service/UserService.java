package com.cemware.nicola.service;

import com.cemware.nicola.repository.GroupRepository;
import com.cemware.nicola.domain.user.User;
import com.cemware.nicola.repository.UserRepository;
import com.cemware.nicola.dto.UserCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@EnableWebSecurity
public class UserService {
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(UserCreateDto dto) {
        User user = User.builder()
                .username(dto.getUserName())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();

        return userRepository.save(user);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException("존재하지 않는 회원입니다."));
    }

    public User updateUser(Long userId, UserCreateDto dto) {
        User user = userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException("존재하지 않는 회원입니다."));
        user.updateUserInformation(dto.getUserName(), dto.getEmail());
        return user;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public Object getUserGroups(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException("존재하지 않는 회원입니다."));
        return groupRepository.findAllByUser(user);
    }
}
