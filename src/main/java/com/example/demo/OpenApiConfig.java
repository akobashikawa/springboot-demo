package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(
            @Value("${app.name:Demo API}") String appName,
            @Value("${app.description:Documentacion de Demo API}") String appDescription,
            @Value("${app.version:1.0}") String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title(appName)
                        .description(appDescription)
                        .version(appVersion));
    }
}