package org.example.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "Account",
        description = "Schema to hold Account information"
)
public class AccountDto {

    @NotEmpty(message = "Account number cannot be null or empty")
    @Pattern(regexp = "(^|[0-9]{10})", message = "account number must be 10 digits")
    @Schema(
            description = "Account Number of Eazy Bank account"
    )
    private Long accountNumber;

    @NotEmpty(message = "Account type cannot be null or empty")
    @Schema(
            description = "Account type of Eazy bank account", example = "Savings"
    )
    private String accountType;

    @Schema(
            description = "Eazy Bank branch address"
    )
    @NotEmpty(message = "Branch address cannot be null or empty")
    private String branchAddress;
}
