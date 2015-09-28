package org.github.wenhao.kafka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/kafka-inbound.xml")
public class KafkaInboundConfiguration {
}
