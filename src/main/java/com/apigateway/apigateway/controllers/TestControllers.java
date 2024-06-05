package com.apigateway.apigateway.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControllers {

    @PostMapping("/test")
    public String TestControllers(@RequestBody String name){

        return name;
    }

}
