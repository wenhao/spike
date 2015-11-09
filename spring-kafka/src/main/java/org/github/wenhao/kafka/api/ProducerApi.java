package org.github.wenhao.kafka.api;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.github.wenhao.kafka.domain.User;
import org.github.wenhao.kafka.service.ConsumerService;
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
    private ConsumerService consumerService;

    @Autowired
    public ProducerApi(ProducerService producerService, ConsumerService consumerService) {
        this.producerService = producerService;
        this.consumerService = consumerService;
    }

    @RequestMapping(method = POST)
    public ResponseEntity<String> produce(@RequestBody User user) {
        producerService.produce(user);
        String message = consumerService.receive();
        return ResponseEntity.ok(message);
    }
}
