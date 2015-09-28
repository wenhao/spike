package org.github.wenhao.kafka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/kafka-outbound.xml")
public class KafkaOutboundConfiguraiton {
}
