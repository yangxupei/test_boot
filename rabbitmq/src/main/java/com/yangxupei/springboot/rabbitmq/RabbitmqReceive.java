package com.yangxupei.springboot.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author : Yang xp
 * Date: 2018/1/22
 * Time: 下午5:05
 * Desc：
 */
@Component
@Slf4j
public class RabbitmqReceive {

    private final RabbitmqConfig rabbitmqConfig;

    public RabbitmqReceive(RabbitmqConfig rabbitmqConfig) {
        this.rabbitmqConfig = rabbitmqConfig;
    }

    @RabbitListener(containerFactory = "factory",queues = "${app.rabbitmq.yangxupei.queues}")
    public void processMessage(byte[] content){
        log.info("消费队列:{}",new String(content));
    }

}
