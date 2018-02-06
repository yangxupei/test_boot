package com.yangxupei.springboot.rabbitmq;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author : Yang xp
 * Date: 2018/1/22
 * Time: 下午3:41
 * Desc：
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    private final RabbitmqProduct rabbitmqProduct;

    public MessageController(RabbitmqProduct rabbitmqProduct) {
        this.rabbitmqProduct = rabbitmqProduct;
    }

    @RequestMapping("/send")
    public String sendMessage(){
        rabbitmqProduct.sendMsg();
        return "success";
    }

    @RequestMapping("/send/{time}")
    public String sendMessageT(@PathVariable String time) throws IOException, TimeoutException {
        rabbitmqProduct.sendMsgConnection(time);
        return "success";
    }


}
