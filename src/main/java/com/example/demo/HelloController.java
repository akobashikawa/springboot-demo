package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @Operation(description = "Hello by name (JSON)", operationId = "helloByNameJson")
    @PostMapping(path = "/hello", consumes = "application/json")
    public String helloJson(@RequestBody HelloRequest request) {
        String name = request.getName() == null ? "World" : request.getName();
        return "Hello " + name + "!";
    }
}
