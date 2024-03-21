package com.example.TBTDD.configs;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title ="TBTDD BACKEND",
                version = "1.0.0",
                description = "This is the application Backend implementation with JPA for the creation and consults querys and more functionalities"
        )
)
public class OpenApiConfig {
}
