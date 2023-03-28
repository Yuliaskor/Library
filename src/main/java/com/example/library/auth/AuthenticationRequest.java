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
public class AuthenticationRequest {

    @Schema(description = "user's email", example = "example@user.com")
    private String email;
    @Schema(description = "user's password", example = "p@ssw0rd")
    String password;
}
