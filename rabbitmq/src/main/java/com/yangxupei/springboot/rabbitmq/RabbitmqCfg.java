package com.yangxupei.springboot.rabbitmq;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.RabbitConnectionFactoryBean;
import org.springframework.amqp.rabbit.connection.SimpleRoutingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author : Yang xp
 * Date: 2018/1/23
 * Time: 下午5:13
 * Desc：
 */
@Configuration
public class RabbitmqCfg {

    private final ConnectionFactory connectionFactory;

    public RabbitmqCfg(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public RabbitConnectionFactoryBean factoryBean(){
        return new RabbitConnectionFactoryBean();
    }

    @Bean
    public SimpleRabbitListenerContainerFactory factory(){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    @Bean
    public AmqpAdmin yangAmqpAdmin(){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public AmqpTemplate yangAmqpTemplate(){
        return new RabbitTemplate(connectionFactory);
    }

}
