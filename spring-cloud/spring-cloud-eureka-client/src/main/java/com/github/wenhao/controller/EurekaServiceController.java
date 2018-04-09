package com.github.wenhao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/clients")
public class EurekaServiceController {

    private DiscoveryClient discoveryClient;
    private RestTemplate restTemplate;

    @Autowired
    public EurekaServiceController(DiscoveryClient discoveryClient, RestTemplate restTemplate) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity eurekaClient() {
        ServiceInstance serviceInstance = this.discoveryClient.getInstances("spring-cloud-eureka-service").get(0);
        return restTemplate.getForEntity(serviceInstance.getUri().toString() + "/services", String.class);
    }
}
