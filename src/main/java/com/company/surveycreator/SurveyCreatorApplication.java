package com.company.surveycreator;

import com.company.surveycreator.config.ProjectProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.company.surveycreator.repository")
@ComponentScan(basePackages = { "com.company.surveycreator.*"})
@EntityScan("com.company.surveycreator.entity")
@EnableConfigurationProperties({ProjectProperties.class})
public class SurveyCreatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyCreatorApplication.class, args);
    }

}
