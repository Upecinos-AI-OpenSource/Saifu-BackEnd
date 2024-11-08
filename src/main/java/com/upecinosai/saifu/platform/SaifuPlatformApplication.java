package com.upecinosai.saifu.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SaifuPlatformApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SaifuPlatformApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SaifuPlatformApplication.class);
    }
}
