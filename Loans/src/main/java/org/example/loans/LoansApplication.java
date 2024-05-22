package org.example.loans;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.example.loans.dto.LoansContactInfoData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {LoansContactInfoData.class})
@OpenAPIDefinition(
        info = @Info(
                title = "loans Microservices API",
                description = "loans microservices REST API Documentation",
                version = "1.0",
                contact = @Contact(
                        name = "Aditya Reddy",
                        email = "aditya.sureshkumarreddy.ciec@skytv.it"
                )
        )
)
public class LoansApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoansApplication.class, args);
    }

}
