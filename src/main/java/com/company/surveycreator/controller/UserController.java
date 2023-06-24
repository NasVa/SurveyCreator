package com.company.surveycreator.controller;

import com.company.surveycreator.dto.AuthorizationDto;
import com.company.surveycreator.dto.RegistrationDto;
import com.company.surveycreator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("users")
public class UserController {
    private final UserService userService;

    @PostMapping("action/registration")
    public AuthorizationDto registration(@RequestBody RegistrationDto registrationDto) {
        return userService.registerUser(registrationDto);
    }

    @PostMapping("action/login")
    public AuthorizationDto login(@RequestBody RegistrationDto registrationDto) {
        return userService.loginUser(registrationDto);
    }
}
