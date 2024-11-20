package com.upecinosai.saifu.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SaifuPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaifuPlatformApplication.class, args);
    }

}

