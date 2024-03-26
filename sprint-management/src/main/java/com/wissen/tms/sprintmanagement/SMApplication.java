package com.wissen.tms.sprintmanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Team Management System", description = "We can use this to create and manage new Sprints.", version = "v1"))

public class SMApplication {
    public static void main(String[] args) {
        SpringApplication.run(SMApplication.class,args);
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
