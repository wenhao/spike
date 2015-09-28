package org.github.wenhao.kafka.api;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.github.wenhao.kafka.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producer")
public class ProducerApi {

    @RequestMapping(method = POST)
    public ResponseEntity produce(@RequestBody User user) {
        return ResponseEntity.ok().build();
    }
}
