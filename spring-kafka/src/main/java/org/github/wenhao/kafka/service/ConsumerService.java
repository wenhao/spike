package org.github.wenhao.kafka.service;

import javax.annotation.Resource;

import org.github.wenhao.kafka.avro.UserAvro;
import org.github.wenhao.kafka.domain.User;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @Resource(name = "inputFromKafka")
    private QueueChannel inputFromKafka;

    public User receive() {
        Message<UserAvro> message = (Message<UserAvro>) inputFromKafka.receive();
        UserAvro userAvro = message.getPayload();

        User user = new User();
        user.setName(userAvro.getName().toString());
        user.setAge(userAvro.getAge());
        return user;
    }
}
