package com.the9o.demo.jooq.config;

import javax.sql.DataSource;

import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import com.the9o.demo.jooq.ExceptionTranslator;
import com.the9o.demo.jooq.models.tables.daos.CustomerDao;

@Configuration
public class InitialConfiguration {

    @Autowired
    private DataSource dataSource;
    
    @Value("${spring.jooq.sql-dialect:POSTGRES}")
    private String DIALECT;

    @Bean
    public DataSourceConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
    }

    @Bean
    public DefaultDSLContext dsl() {
        return new DefaultDSLContext(configuration());
    }
    
    @Bean
    public CustomerDao customerDao() {
        return new CustomerDao(configuration());
    }

    public DefaultConfiguration configuration() {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration.set(connectionProvider());
        jooqConfiguration.set(new DefaultExecuteListenerProvider(new ExceptionTranslator()));
        jooqConfiguration.set(SQLDialect.valueOf(DIALECT.toUpperCase()));
        return jooqConfiguration;
    }

}