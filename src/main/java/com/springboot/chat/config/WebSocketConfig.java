package com.springboot.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//We have to add @Configuration to tell Spring Boot this is a configuration class
@Configuration
//We have to enable WebsocketMessageBroker with annotation @EnableWebSocketMessageBroker
@EnableWebSocketMessageBroker
//We need to implement an interface name WebSocketMessageBrokerConfigurer
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    //We need to overwrite 2 methods, registerStompEndpoints() and configureMessageBroker()

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
