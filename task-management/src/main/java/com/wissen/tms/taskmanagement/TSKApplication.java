package com.wissen.tms.taskmanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Team Management System", description = "We can use this to create and manage new Task.", version = "v1"))
public class TSKApplication {
    public static void main(String[] args) {
        SpringApplication.run(TSKApplication.class,args);
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
