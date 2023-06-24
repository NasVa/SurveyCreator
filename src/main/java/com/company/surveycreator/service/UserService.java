package com.company.surveycreator.service;

import com.company.surveycreator.dto.AuthorizationDto;
import com.company.surveycreator.dto.RegistrationDto;
import com.company.surveycreator.model.User;
import com.company.surveycreator.repository.UserRepository;
import com.company.surveycreator.util.JwtUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Transactional
    public AuthorizationDto registerUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setLogin(registrationDto.getLogin());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        userRepository.save(user);
        return new AuthorizationDto(JwtUtils.generateToken(user));
    }

    @Transactional
    public AuthorizationDto loginUser(RegistrationDto registrationDto) {
        User user = userRepository.findByLoginAndPassword(registrationDto.getLogin(), registrationDto.getPassword())
                .orElseThrow(() -> new RuntimeException("Not found")); //todo create exception
        return new AuthorizationDto(JwtUtils.generateToken(user));
    }
}
