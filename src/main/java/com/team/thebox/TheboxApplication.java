package com.team.thebox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TheboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheboxApplication.class, args);
    }

}
