package com.apigateway.apigateway.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StaffDto {
    private String id;
    private String nameStaff;
    private String email;
    private String password;
    private String oldStaff;
    private String addressStaff;
    private String createAt;
    private String updateAt;
    private String deleteAt;
}
