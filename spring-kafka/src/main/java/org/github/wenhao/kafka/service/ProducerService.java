package org.github.wenhao.kafka.service;

import javax.annotation.Resource;

import org.github.wenhao.kafka.avro.UserAvro;
import org.github.wenhao.kafka.domain.User;
import org.springframework.integration.kafka.support.KafkaHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Resource(name = "inputToKafka")
    private MessageChannel inputToKafka;

    public void produce(User user) {
        UserAvro specificUser = UserAvro.newBuilder()
                .setName(user.getName())
                .setAge(user.getAge())
                .build();
        Message<UserAvro> message = MessageBuilder.withPayload(specificUser)
                .setHeader(KafkaHeaders.MESSAGE_KEY, "user")
                .setHeader(KafkaHeaders.TOPIC, "test")
                .build();
        inputToKafka.send(message);
    }

}
