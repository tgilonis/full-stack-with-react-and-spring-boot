package com.tgilonis.rest.basic.controller;

import com.tgilonis.rest.basic.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller - handles HTTP (rest) requests
@RestController
// Allow requests from localhost 4200
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthenticationController
{

    @GetMapping(path="/basicauth")
    public AuthenticationBean helloWorldBean()
    {
        return new AuthenticationBean("You are Authenticated!");
    }

}
