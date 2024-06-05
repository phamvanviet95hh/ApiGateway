package com.apigateway.apigateway.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StaffRespon {
    private String id;
    private String nameStaff;
    private String email;
    private String oldStaff;
    private String addressStaff;
}
