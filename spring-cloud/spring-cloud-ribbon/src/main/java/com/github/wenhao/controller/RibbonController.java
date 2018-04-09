package com.github.wenhao.controller;

import com.github.wenhao.config.EurekaConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbons")
@RibbonClient(name = "spring-cloud-eureka-service", configuration = EurekaConfiguration.class)
public class RibbonController {

    private RestTemplate restTemplate;

    @Autowired
    public RibbonController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity eurekaClient() {
        return this.restTemplate.getForEntity("http://spring-cloud-eureka-service/services", String.class);
    }
}
