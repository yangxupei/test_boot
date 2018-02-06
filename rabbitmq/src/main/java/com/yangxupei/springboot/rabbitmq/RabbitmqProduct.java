package com.yangxupei.springboot.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author : Yang xp
 * Date: 2018/1/22
 * Time: 上午11:19
 * Desc：
 */
@Component
@Slf4j
public class RabbitmqProduct {

    private final AmqpAdmin yangAmqpAdmin;
    private final AmqpTemplate yangAmqpTemplate;
    private final RabbitmqConfig rabbitmqConfig;
    private final ConnectionFactory connectionFactory;

    public RabbitmqProduct(AmqpAdmin yangAmqpAdmin, AmqpTemplate yangAmqpTemplate,
                           RabbitmqConfig rabbitmqConfig, ConnectionFactory connectionFactory) {
        this.yangAmqpAdmin = yangAmqpAdmin;
        this.yangAmqpTemplate = yangAmqpTemplate;
        this.rabbitmqConfig = rabbitmqConfig;
        this.connectionFactory = connectionFactory;
    }

    public void sendMsg(){
        log.info("发送mq,exchange:{},routingKey:{}",rabbitmqConfig.getExchange(),rabbitmqConfig.getRoutingKey());
        yangAmqpTemplate.convertAndSend(rabbitmqConfig.getExchange(),rabbitmqConfig.getRoutingKey(),"这个就是一个mq的测试不要着急");
    }

    public void sendMsgConnection(String time) throws IOException, TimeoutException {
//        Channel channel = new ChannelN();
        Connection connection = connectionFactory.createConnection();
        Map<String,Object> header = new HashMap<>();
        header.put("x-dead-letter-exchange","e_letter_yangxupei");
        header.put("x-message-ttl",Long.valueOf(time));
        Channel channel = connection.createChannel(false);
        String QUEUE_NAME = "q_no_time_test";
        String EXCHANGE_NAME = "e_no_time_test";
        channel.queueDeclare(QUEUE_NAME, true, true, true, header);
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT,true,false,null);
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,rabbitmqConfig.getRoutingKey());
        log.info("发送mq消息:{}",time);
        channel.basicPublish(EXCHANGE_NAME,rabbitmqConfig.getRoutingKey(),new AMQP.BasicProperties.Builder()
                .build(),("测试消息:"+time).getBytes());
        channel.close();
        connection.close();
    }




}
