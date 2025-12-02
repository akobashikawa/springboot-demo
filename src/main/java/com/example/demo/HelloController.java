package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Hello", description = "Hello API")
public class HelloController {

    @Operation(description = "Hello World", operationId = "helloWorld")
    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello World!";
    }

    @Operation(description = "Hello by name", operationId = "helloByName")
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name + "!";
    }
}
