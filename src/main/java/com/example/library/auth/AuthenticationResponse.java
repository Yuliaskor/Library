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
public class AuthenticationResponse {

    @Schema(
            description = "jwt token",
            example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2Nzk5NDQ1OTQsImV4cCI6MTY3OTk0NjAzNH0.DMEaR54mJMTsUYZObg8L50eRJX2hr5nRG8EmHdYFlTI"
    )
    private String token;
}
