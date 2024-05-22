package org.example.accounts;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.example.accounts.dto.AccountsContactInfoData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoData.class})
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice API",
				description = "accounts microservice REST API Documentation",
				version = "1.0",
				contact = @Contact(
						name = "Aditya Reddy",
						email = "aditya.sureshkumarreddy.ciec@skytv.it"
				)
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
