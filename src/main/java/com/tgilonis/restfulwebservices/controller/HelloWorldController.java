package com.tgilonis.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Controller - handles HTTP (rest) requests
@RestController
public class HelloWorldController
{
    // GET
    // URI - /hello-world
    // method - "Hello World"
    @GetMapping(path="/hello-world")
    public String helloWorld()
    {
        return "Hello World!";
    }
}
