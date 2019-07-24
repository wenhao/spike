package com.github.wenhao.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "SPRING-CLOUD-SERVICE-PROVIDER")
public interface EurekaServiceClient {

    @RequestMapping(value = "services", method = RequestMethod.GET)
    String get();
}
