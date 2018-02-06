package com.yangxupei.boot.datasource.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author : Yang xp
 * Date: 2018/1/26
 * Time: 上午10:52
 * Desc：
 */
@Configuration
@MapperScan(basePackages = "com.yangxupei.boot.datasource.mapper", sqlSessionFactoryRef = "clusterSqlSessionFactory")
public class DatabaseConfig {

    @Value("${app.datasource.check.url}")
    private String url;
    @Value("${app.datasource.check.username}")
    private String username;
    @Value("${app.datasource.check.password}")
    private String password;
    @Value("${app.datasource.check.driverClassName}")
    private String driverClassName;

    @Bean
    @ConfigurationProperties(prefix = "app.datasource.check")
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager(@Qualifier("dataSource") DataSource clusterDataSource) {
        return new DataSourceTransactionManager(clusterDataSource);
    }

    @Bean(name = "clusterSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("dataSource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(""));
        return sessionFactory.getObject();
    }

}
