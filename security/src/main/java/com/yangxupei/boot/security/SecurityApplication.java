package com.yangxupei.boot.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : Yang xp
 * Date: 2018/2/2
 * Time: 上午11:27
 * Desc：
 */
@SpringBootApplication
@MapperScan(basePackages = "com.yangxupei.boot.security.db.mapper",sqlSessionFactoryRef = "sqlSessionFactory")
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class,args);
    }

}
