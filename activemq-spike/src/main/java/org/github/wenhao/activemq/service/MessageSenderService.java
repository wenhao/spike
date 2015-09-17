package org.github.wenhao.activemq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService
{
    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String message)
    {
        jmsTemplate.send("test", session -> {
            return session.createTextMessage(message);
        });
    }
}
