package com.github.wenhao.controller;

import com.github.wenhao.config.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringConfigClientController {

    private SpringConfig springConfig;

    @Autowired
    public SpringConfigClientController(SpringConfig springConfig) {
        this.springConfig = springConfig;
    }

    @GetMapping(path = "/username")
    public ResponseEntity get() {
        return ResponseEntity.ok(springConfig.getUsername());
    }
}
