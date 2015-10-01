package org.github.wenhao.kafka.service;

import javax.annotation.Resource;

import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @Resource(name = "inputFromKafka")
    private QueueChannel inputFromKafka;

    public void receive() {
        Message<?> message = inputFromKafka.receive();
        Object payload = message.getPayload();
        System.out.println(payload);
    }
}
