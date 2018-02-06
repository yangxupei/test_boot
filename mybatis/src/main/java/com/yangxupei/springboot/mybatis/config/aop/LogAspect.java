package com.yangxupei.springboot.mybatis.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author : Yang xp
 * Date: 2018/1/26
 * Time: 下午5:19
 * Desc：
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void handle(){
        log.info("日志开始打起来");
    }

    @Before(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void before(JoinPoint joinPoint){
        log.info("日志开始打起来开始");
    }

}
