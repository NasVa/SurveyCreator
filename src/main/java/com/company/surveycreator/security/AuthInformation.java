package com.company.surveycreator.security;

import java.util.List;

import com.company.surveycreator.entity.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthInformation {
    private String token;
    private long expires;

    private String username;
    private Long userId;
    private List<Role> authorities;

}
