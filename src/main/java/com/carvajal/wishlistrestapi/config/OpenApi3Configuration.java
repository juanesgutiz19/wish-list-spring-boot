package com.carvajal.wishlistrestapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Wishlist API", version = "1.0", description = "Rest API of whitelist made with Spring Boot"))
public class OpenApi3Configuration {

    @Bean
    public OpenAPI customOpenAPI(@Value("http://localhost:8080/") String url) {
        Server server = new Server();
        server.setUrl(url);

        return new OpenAPI().servers(List.of(server));
    }
}