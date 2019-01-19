package com.blogs.user.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;


@ComponentScan


@Configuration
public class ApplicationConfig {
    @Autowired
    private Environment environment;

    @Bean
    public DataSource getDataSource(){
        DruidDataSource data = new DruidDataSource();
        data.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        data.setUsername(environment.getProperty("spring.datasource.data-username"));
        data.setPassword(environment.getProperty("spring.datasource.data-password"));
        data.setUrl(environment.getProperty("spring.datasource.url"));
        return data;
    }

/*    @Bean
    @ConditionalOnMissingBean
    public SqlSessionFactory sqlSessionFactory(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
         factory.setDataSource(getDataSource());
         factory.setMapperLocations(applicationContext.getResources("classpath:mapping/*.xml"));
         factory.setVfs(SpringBootVFS.class);
     return factory.getObject();
    }*/

}
