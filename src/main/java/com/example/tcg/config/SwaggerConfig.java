package com.example.tcg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI api() {
            return new OpenAPI()
                .info(new Info()
                    .title("TCG-Project-API-Productos")
                    .version("1.0")
                    .description("Swagger API para la gestión de productos de tienda tcg."));
    }
}
