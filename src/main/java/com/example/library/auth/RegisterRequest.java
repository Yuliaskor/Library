package com.example.library.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @Schema(description = "user's firstname", example = "Adam")
    private String firstname;
    @Schema(description = "user's lastname", example = "Małysz")
    private String lastname;
    @Schema(description = "user's email", example = "example@user.com")
    private String email;
    @Schema(description = "user's password", example = "p@ssw0rd")
    private String password;
}
