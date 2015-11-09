package org.github.wenhao.kafka.service;

import javax.annotation.Resource;

import static org.springframework.util.StringUtils.isEmpty;

import org.github.wenhao.kafka.avro.UserAvro;
import org.github.wenhao.kafka.domain.User;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ConsumerService {
    @Resource(name = "inputFromKafka")
    private QueueChannel inputFromKafka;

    public String receive() {
//        Message<UserAvro> message = (Message<UserAvro>) inputFromKafka.receive(5000);
//        UserAvro userAvro = message.getPayload();
//
//        User user = new User();
//        user.setName(userAvro.getName().toString());
//        user.setAge(userAvro.getAge());
        Message<String> message = (Message<String>) inputFromKafka.receive(5000);
        if(message != null){
            return message.getPayload();
        }
        return "";
    }
}
