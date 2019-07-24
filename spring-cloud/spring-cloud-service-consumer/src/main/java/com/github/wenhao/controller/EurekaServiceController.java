package com.github.wenhao.controller;

import com.github.wenhao.client.EurekaServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class EurekaServiceController {

    private EurekaServiceClient eurekaServiceClient;

    @Autowired
    public EurekaServiceController(EurekaServiceClient eurekaServiceClient) {
        this.eurekaServiceClient = eurekaServiceClient;
    }

    @GetMapping
    public ResponseEntity eurekaClient() {
        String eurekaService = eurekaServiceClient.get();
        return ResponseEntity.ok(eurekaService);
    }
}
