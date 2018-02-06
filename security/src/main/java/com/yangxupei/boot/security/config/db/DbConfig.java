package com.yangxupei.boot.security.config.db;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author : Yang xp
 * Date: 2018/2/2
 * Time: 下午4:35
 * Desc：
 */
@Configuration
public class DbConfig {

    @Bean
    @ConfigurationProperties(prefix = "app.datasource.test")
    public DataSource reserveDatasource() {
        return new DruidDataSource();
    }


    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(reserveDatasource());
        String mapperLocationPath = "classpath*:mapper/*.xml";
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocationPath));
        return sqlSessionFactoryBean.getObject();
    }

}
