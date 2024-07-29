package elo.tech.biblioteca.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@PropertySource("classpath:application.production.properties")
public class IntegracaoApiGoogleBooksConfig {
    @Value("${api.key}")
    private String apiKey;

}
