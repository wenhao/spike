package com.github.wenhao.controller;

import com.github.wenhao.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringConfigClientController {

    private ApplicationConfig applicationConfig;

    @Autowired
    public SpringConfigClientController(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    @GetMapping(path = "/kubernetes")
    public ResponseEntity getEnv() {
        return ResponseEntity.ok("env: " + applicationConfig.getEnv());
    }
}
