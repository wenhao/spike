package org.github.wenhao.kafka.service;

import org.github.wenhao.kafka.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.kafka.support.KafkaHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private MessageChannel inputToKafka;

    @Autowired
    public ProducerService(MessageChannel inputToKafka) {
        this.inputToKafka = inputToKafka;
    }

    public void produce(User user) {
        Message<User> message = MessageBuilder.withPayload(user)
                .setHeader(KafkaHeaders.MESSAGE_KEY, "user")
                .setHeader(KafkaHeaders.TOPIC, "test")
                .build();
        inputToKafka.send(message);
    }

}
