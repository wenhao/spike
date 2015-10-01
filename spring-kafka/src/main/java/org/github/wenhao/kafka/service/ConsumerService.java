package org.github.wenhao.kafka.service;

import javax.annotation.Resource;

import org.github.wenhao.kafka.domain.user.User;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @Resource(name = "inputFromKafka")
    private QueueChannel inputFromKafka;

    public User receive() {
        Message<User> message = (Message<User>) inputFromKafka.receive();
        User user = message.getPayload();
        return user;
    }
}
