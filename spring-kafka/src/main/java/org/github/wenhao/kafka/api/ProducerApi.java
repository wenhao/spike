package org.github.wenhao.kafka.api;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.github.wenhao.kafka.domain.User;
import org.github.wenhao.kafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producer")
public class ProducerApi {

    private ProducerService producerService;

    @Autowired
    public ProducerApi(ProducerService producerService) {
        this.producerService = producerService;
    }

    @RequestMapping(method = POST)
    public ResponseEntity produce(@RequestBody User user) {
        producerService.produce(user);
        return ResponseEntity.ok(user);
    }
}
