package com.example.PlacaSegura.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenApi() {
    return new OpenAPI()
            .info(new Info()
                    .title("API App")
                    .version("1.0")
                    .description("Documentacion de la API de PlacaSegurApp")
                    .contact(new Contact()
                            .name("Placa segurapp API")
                            .email("juliandherrera@ucundinamarca.edu.co")));
    }
}

