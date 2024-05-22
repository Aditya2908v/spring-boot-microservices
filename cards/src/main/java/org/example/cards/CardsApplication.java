package org.example.cards;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.example.cards.dto.CardsContactInfoData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {CardsContactInfoData.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Cards Microservices API",
                description = "cards microservices REST API Documentation",
                version = "1.0",
                contact = @Contact(
                        name = "Aditya Reddy",
                        email = "aditya.sureshkumarreddy.ciec@skytv.it"
                )
        )
)
public class CardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardsApplication.class, args);
    }

}
