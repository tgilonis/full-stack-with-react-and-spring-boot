package com.tgilonis.restfulwebservices.controller;

import com.tgilonis.restfulwebservices.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
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



    // hello-world-bean
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean()
    {
        return new HelloWorldBean("Hello World!");
    }
}
