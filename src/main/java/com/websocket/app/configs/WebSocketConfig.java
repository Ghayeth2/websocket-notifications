package com.websocket.app.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Configuration class for WebSocket configs.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

    /**
     * Enabling Message Broker & Broadcasting,
     * Telling Spring under which prefix to expect the channels 
     * of broadcasting to be, Meaning: all channels that include
     * the prefix /topic they will be handled by Spring & reconized 
     * as broadcasting ones. 
     * Telling Spring what is the my app's endpoint in 
     * which requests will come under
     * prefix /app or /api or /atm or /aas or /labsis
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app", "/api");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Url of connecting WebSocked
        registry.addEndpoint("/app/ws/connect")
                // What origins are accepted to connect
                .setAllowedOrigins("localhost:8080")
                // In case of failure connection
                .withSockJS();
    }

}
