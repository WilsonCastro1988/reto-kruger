package com.kruger.ec.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/*
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "adminEntityManagerFactory",
        transactionManagerRef = "adminTransactionManager",
        basePackages = {
                "com.kruger.repository.admin"
        }
)*/
public class PublicConfig {
/*
    @Primary
    @Bean(name = "adminDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource customerDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "adminEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("adminDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.kruger.admin")
                .persistenceUnit("db1")
                .build();
    }

    @Primary
    @Bean(name = "adminTransactionManager")
    public PlatformTransactionManager customerTransactionManager(
            @Qualifier("adminEntityManagerFactory") EntityManagerFactory customerEntityManagerFactory
    ) {
        return new JpaTransactionManager(customerEntityManagerFactory);
    }

*/


}
