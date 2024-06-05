package com.apigateway.apigateway.dtos.requests;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
