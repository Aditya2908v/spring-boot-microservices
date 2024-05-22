package org.example.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDto {

    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    @Schema(
            description = "Name of the customer", example = "Aditya"
    )
    private String name;

    @NotEmpty(message = "Email cannot be null or empty")
    @Email(message = "Email address should be a valid value")
    @Schema(
            description = "email of the customer", example = "aditya@gmail.com"
    )
    private String email;

    @Pattern(regexp = "(^|[0-9]{10})", message = "Mobile number must be 10 digits")
    @Schema(
            description = "mobile number of the customer", example = "6302208871"
    )
    private String mobileNumber;

    @Schema(
            name = "Account details of the Customer"
    )
    private AccountDto accountDto;
}
