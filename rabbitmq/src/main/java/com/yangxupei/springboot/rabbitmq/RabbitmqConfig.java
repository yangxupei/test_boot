package com.yangxupei.springboot.rabbitmq;


import lombok.Getter;
import lombok.Setter;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Yang xp
 * Date: 2018/1/22
 * Time: 上午11:46
 * Desc：
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "app.rabbitmq.yangxupei")
@Configuration
public class RabbitmqConfig {
    private String exchange;
    private String routingKey;
    private String queues;

    @Bean
    @ConfigurationProperties("app.rabbitmq.yangxupei")
    public CachingConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }
}
