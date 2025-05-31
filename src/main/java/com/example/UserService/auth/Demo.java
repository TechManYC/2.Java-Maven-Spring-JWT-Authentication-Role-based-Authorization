package com.example.UserService.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
public class Demo {

    @PostMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from secure endpoint");
    }

}
