package com.yangxupei.springboot.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

/**
 * @author : Yang xp
 * Date: 2018/1/22
 * Time: 上午11:16
 * Desc：
 */
@SpringBootApplication
public class RabbitmqApplication {

    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(RabbitmqApplication.class);
//        application.setWebEnvironment(true);
//        application.run(args);
        SpringApplication.run(RabbitmqApplication.class,args);
    }

//    @Bean
//    public EmbeddedServletContainerFactory factory(){
//        return new JettyEmbeddedServletContainerFactory();
//    }

}
