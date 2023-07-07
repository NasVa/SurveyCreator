package com.company.surveycreator.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@EnableConfigurationProperties
@Component
@ConfigurationProperties(prefix = "surveycreator")
@Data
public class ProjectProperties {
    private Jwt jwt;
    @Data
    public static class Jwt{
        private String secret;

    }
}
