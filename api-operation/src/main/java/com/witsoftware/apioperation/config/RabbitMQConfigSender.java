package com.witsoftware.apioperation.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class RabbitMQConfigSender {

	@Value("${direct.exchange.name}")
	private String directExchangeName;
	
	@Value("${routing.key}")
	private String routingKey;

	@Autowired
    private RabbitTemplate template;

	@Autowired
    private DirectExchange exchange;
	
    @Bean	
    DirectExchange exchange() {
        return new DirectExchange(directExchangeName);
    }
	
    public Object sendAndReturn(String message) { 
    	log.info("Send message");
    	return template.convertSendAndReceive(exchange.getName(), routingKey, message);
    }
}
