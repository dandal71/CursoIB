package com.ib.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mysql.cj.jdbc.MysqlDataSource;

//@Configuration
@PropertySource("classpath:jdbc.properties")
public class DatasourceCfg {

    @Value("${jdbc.url}")
    private String url;
    
    @Value("${jdbc.username}")
    private String user;
    
    @Value("${jdbc.password}")
    private String password;
    
    @Bean
    public DataSource getDataSource() {
        
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }
}
