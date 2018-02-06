package com.yangxupei.springboot.mybatis.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author : Yang xp
 * Date: 2018/1/25
 * Time: 下午3:15
 * Desc：
 */
@Configuration
//@MapperScan(basePackages = "com.yangxupei.springboot.mybatis.mapper", sqlSessionFactoryRef = "sqlSessionFactoryBean")
public class DatabaseConfig {

    @Value("${app.datasource.reserve.url}")
    private String url;
    @Value("${app.datasource.reserve.username}")
    private String username;
    @Value("${app.datasource.reserve.password}")
    private String password;



//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(reserveDatasource());
//        String mapperLocationPath = "classpath*:mapper/*.xml";
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocationPath));
//        return sqlSessionFactoryBean.getObject();
//    }
//
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("com.yangxupei.springboot.mybatis.mapper");
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
//        return mapperScannerConfigurer;
//    }


}
