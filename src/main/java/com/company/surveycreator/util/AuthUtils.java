package com.company.surveycreator.util;

import com.company.surveycreator.security.AuthInformation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtils {

    public static void setAuth(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public static AuthInformation getAuthInformation() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (AuthInformation) authentication.getPrincipal();
    }
}
