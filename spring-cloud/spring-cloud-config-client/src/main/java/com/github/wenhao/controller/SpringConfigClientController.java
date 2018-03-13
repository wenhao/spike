package com.github.wenhao.controller;

import com.github.wenhao.config.ApplicationConfig;
import com.github.wenhao.config.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringConfigClientController {

    private SpringConfig springConfig;
    private ApplicationConfig applicationConfig;

    @Autowired
    public SpringConfigClientController(SpringConfig springConfig, ApplicationConfig applicationConfig) {
        this.springConfig = springConfig;
        this.applicationConfig = applicationConfig;
    }

    @GetMapping(path = "/username")
    public ResponseEntity get() {
        return ResponseEntity.ok("username: " + springConfig.getUsername());
    }

    @GetMapping(path = "/env")
    public ResponseEntity getEnv() {
        return ResponseEntity.ok("env: " + applicationConfig.getEnv());
    }
}
