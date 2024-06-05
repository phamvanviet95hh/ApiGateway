package com.apigateway.apigateway.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "StaffDocument")
@Data
@Builder
public class StaffModel {

    @Id
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
