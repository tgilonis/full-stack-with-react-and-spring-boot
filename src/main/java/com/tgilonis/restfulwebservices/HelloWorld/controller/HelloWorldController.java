package com.tgilonis.restfulwebservices.HelloWorld.controller;

import com.tgilonis.restfulwebservices.HelloWorld.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Controller - handles HTTP (rest) requests
@RestController
// Allow requests from localhost 4200
@CrossOrigin(origins = "http://localhost:4200")
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

    // hello-world-bean/path-variable/{name}
    @GetMapping(path="/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
    {
        //throw new RuntimeException("Something went wrong"); // use for testing error handling in frontend
        return new HelloWorldBean(String.format("Hello World, %s!", name));
    }
}
