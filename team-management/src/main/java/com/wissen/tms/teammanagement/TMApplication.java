package com.wissen.tms.teammanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.*;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Team Management System", description = "We can use this to create and manage new Teams.", version = "v1"))

public class TMApplication {
    public static void main(String[] args) {
        SpringApplication.run(TMApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
