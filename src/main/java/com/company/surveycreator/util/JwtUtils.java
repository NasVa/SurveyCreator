package com.company.surveycreator.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.company.surveycreator.config.ProjectProperties;
import com.company.surveycreator.entity.User;
import com.company.surveycreator.security.AuthInformation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils {
    private final Algorithm ALGORITHM;
    private final ProjectProperties projectProperties;

    public JwtUtils(ProjectProperties projectProperties) {
        this.projectProperties = projectProperties;
        ALGORITHM = Algorithm.HMAC256(projectProperties.getJwt().getSecret());
    }

    public String generateToken(User user) {
        Date now = new Date();
        Date exp = Date.from(LocalDateTime.now().plusHours(1)
                .atZone(ZoneId.systemDefault()).toInstant());
        return JWT.create()
                .withIssuedAt(now)
                .withNotBefore(now)
                .withExpiresAt(exp)
                .withClaim("userId", user.getId()) //TODO roles
                .sign(ALGORITHM);
    }

    public AuthInformation parseToken(String token){
        Map<String, Claim> claims = JWT.require(ALGORITHM)
                .build()
                .verify(token.substring(7))
                .getClaims();
        return AuthInformation.builder()
                .userId(claims.get("userId").asLong())
                .build();
    }
}