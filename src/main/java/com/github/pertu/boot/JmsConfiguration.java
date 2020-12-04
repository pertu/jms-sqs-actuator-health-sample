package com.github.pertu.boot;

import org.springframework.boot.autoconfigure.jms.JmsProperties.AcknowledgeMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class JmsConfiguration {
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(
            ConnectionFactory sqsConnectionFactory) {

        var factory = new DefaultJmsListenerContainerFactory();

        factory.setConnectionFactory(sqsConnectionFactory);
        /* to avoid unsupported-by-SQS "transacted" mode: */
        factory.setSessionAcknowledgeMode(AcknowledgeMode.CLIENT.getMode());

        return factory;
    }
}
