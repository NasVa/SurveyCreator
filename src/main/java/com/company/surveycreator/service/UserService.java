package com.company.surveycreator.service;

import com.company.surveycreator.dto.AuthorizationDto;
import com.company.surveycreator.dto.RegistrationDto;
import com.company.surveycreator.dto.UserDto;
import com.company.surveycreator.entity.User;
import com.company.surveycreator.repository.UserRepository;
import com.company.surveycreator.util.AuthUtils;
import com.company.surveycreator.util.JwtUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, JwtUtils jwtUtils) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
    }

    @Transactional
    public AuthorizationDto registerUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setLogin(registrationDto.getLogin());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        userRepository.save(user);
        return new AuthorizationDto(jwtUtils.generateToken(user));
    }

    @Transactional
    public AuthorizationDto loginUser(RegistrationDto registrationDto) {
        User user = userRepository.findByLogin(registrationDto.getLogin())
                .filter(u -> passwordEncoder.matches(registrationDto.getPassword(),u.getPassword()))
                .orElseThrow(() -> new RuntimeException("Not found")); //todo create exception
        return new AuthorizationDto(jwtUtils.generateToken(user));
    }

    @Transactional
    public UserDto findMe(){
        User user = userRepository.findById(AuthUtils.getAuthInformation().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .build();
    }
}
