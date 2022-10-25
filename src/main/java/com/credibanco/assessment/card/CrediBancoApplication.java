package com.credibanco.assessment.card;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CrediBancoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CrediBancoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CrediBancoApplication.class);
    }
}