package com.springsecurity.springsecurityexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExampleController {


    @GetMapping("/admin/{id}")
    public void admin(@PathVariable("id") String id) {
    	
    	
        System.out.println(id);
    }
}
