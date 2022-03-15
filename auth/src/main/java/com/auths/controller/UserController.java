package com.auths.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    
    @RequestMapping("/getCurrentUser")
    public int getCurrentUser(@RequestHeader("memberId") int memberId) {
       // return authentication.getPrincipal();
        return memberId+1;
    }
}