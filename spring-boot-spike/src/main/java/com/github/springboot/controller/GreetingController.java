package com.github.springboot.controller;

import com.github.springboot.exception.CustomException;
import com.github.springboot.request.CreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping("greeting")
public class GreetingController {

    @PostMapping
    public ResponseEntity create(@Validated CreateRequest createRequest) {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity controllerAdvice() {
        throw new CustomException("自定义异常");
    }
}
