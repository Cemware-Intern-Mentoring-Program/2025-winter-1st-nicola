package com.cemware.nicola.service;

import com.cemware.nicola.domain.user.User;
import com.cemware.nicola.repository.UserRepository;
import com.cemware.nicola.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserId(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        log.info("user.getUserName() {}, user.getPassword() {}", user.getUsername(), user.getPassword());

        return new CustomUserDetails(user);
    }

}
