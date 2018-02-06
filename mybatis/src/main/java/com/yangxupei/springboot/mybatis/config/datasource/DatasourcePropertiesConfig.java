package com.yangxupei.springboot.mybatis.config.datasource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author : Yang xp
 * Date: 2018/1/25
 * Time: 下午3:54
 * Desc：
 */
@Getter
@Setter
@ToString
@ConfigurationProperties("app.datasource.reserve")
@Configuration
public class DatasourcePropertiesConfig {
    private String url;
    private String username;
    private String password;
}
