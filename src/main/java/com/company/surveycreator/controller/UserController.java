package com.company.surveycreator.controller;

import com.company.surveycreator.dto.AuthorizationDto;
import com.company.surveycreator.dto.RegistrationDto;
import com.company.surveycreator.dto.UserDto;
import com.company.surveycreator.entity.User;
import com.company.surveycreator.repository.UserRepository;
import com.company.surveycreator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
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

    @GetMapping("/findme")
    public UserDto findMe(){
        return userService.findMe();
    }

}
