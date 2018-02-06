package com.yangxupei.springboot.mybatis.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author : Yang xp
 * Date: 2018/1/25
 * Time: 下午3:20
 * Desc：
 */
@Configuration
@MapperScan(basePackages = "com.yangxupei.springboot.mybatis.mapper", sqlSessionFactoryRef = "clusterSqlSessionFactory")
public class TransactionConfig {

    @Bean
    @ConfigurationProperties(prefix = "app.datasource.check")
    public DataSource reserveDatasource() {
        return new DruidDataSource();
    }


    @Bean(name = "clusterSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(reserveDatasource());
        String mapperLocationPath = "classpath*:mapper/*.xml";
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocationPath));
        return sqlSessionFactoryBean.getObject();
    }

//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("com.yangxupei.springboot.mybatis.mapper");
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
//        return mapperScannerConfigurer;
//    }



}
