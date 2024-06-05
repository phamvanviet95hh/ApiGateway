package com.apigateway.apigateway.controllers;

import com.apigateway.apigateway.dtos.StaffDto;
import com.apigateway.apigateway.dtos.requests.LoginRequest;
import com.apigateway.apigateway.dtos.response.LoginResponse;
import com.apigateway.apigateway.dtos.response.ResponAll;
import com.apigateway.apigateway.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/gtelservice")
public class StaffControllers {

    @Autowired
    private StaffService staffService;

    @Autowired
    private AuthenticationManager authenticationManager;
    private Boolean success = false;
    private String message = null;

    @PostMapping("/createStaff")
    public ResponAll createStaff(@RequestBody StaffDto staffDto){
        int checkCreate = staffService.createStaff(staffDto);
        if(checkCreate == 1){
            success = true;
            message = "Create Staff SuccessFull";
        }else {
            message = "Create Staff Fail!!!";
        }
        return new ResponAll(success, message);
    }

    @PostMapping("/login")
    public LoginResponse createStaff(@RequestBody LoginRequest loginRequest){
        return staffService.login(loginRequest);
    }
}