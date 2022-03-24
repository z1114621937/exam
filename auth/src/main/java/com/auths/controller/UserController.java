package com.auths.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/getCurrentUser")
    public String getCurrentUser(@RequestHeader(name = "school") String school) {
       // return authentication.getPrincipal();

        return school;
    }
}