package com.apigateway.apigateway.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {

    private Boolean success;
    private String message;
    private String token;
    private StaffRespon data;

}
