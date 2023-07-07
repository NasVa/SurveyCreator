package com.company.surveycreator.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class JwtAuthToken extends AbstractAuthenticationToken {

    private final AuthInformation authInformation;

    public JwtAuthToken(AuthInformation authInformation) {
        super(List.of());
        this.authInformation = authInformation;
        this.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return authInformation.getToken();
    }

    @Override
    public Object getPrincipal() {
        return authInformation;
    }
}
