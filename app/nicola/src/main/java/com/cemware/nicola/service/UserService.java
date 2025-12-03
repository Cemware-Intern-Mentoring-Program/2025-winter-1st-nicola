package com.cemware.nicola.service;

import com.cemware.nicola.dto.UserDetailDto;
import com.cemware.nicola.repository.GroupRepository;
import com.cemware.nicola.repository.TaskRepository;
import com.cemware.nicola.domain.user.User;
import com.cemware.nicola.repository.UserRepository;
import com.cemware.nicola.dto.UserCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final TaskRepository taskRepository;

    public User createUser(UserCreateDto dto) {
        User user = User.builder()
                .userName(dto.getUserName())
                .email(dto.getEmail())
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
