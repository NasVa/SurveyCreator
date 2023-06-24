package com.company.surveycreator.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.company.surveycreator.model.User;

public class JwtUtils {
    private static final Algorithm ALGORITHM = Algorithm.HMAC256("survey"); //TODO move to config

    public static String generateToken(User user) {
        return JWT.create()
                .withClaim("userId", user.getId()) //TODO roles
                .sign(ALGORITHM);
    }
}
