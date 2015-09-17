package org.github.wenhao.activemq.api;

import org.github.wenhao.activemq.service.MessageSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "test")
public class ActiveMQApi
{
    @Autowired
    private MessageSenderService messageSenderService;

    @RequestMapping(method = POST)
    public ResponseEntity test(@RequestBody Map<String, String> messages)
    {
        messageSenderService.send(messages.get("message"));
        return new ResponseEntity(HttpStatus.OK);
    }
}
