package com.supermonk.cloud; 

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = {"com.supermonk.cloud.entity"})
@EnableJpaRepositories(entityManagerFactoryRef = "rdsEntityManagerFactory", transactionManagerRef = "rdsTransactionManager", basePackages = "com.supermonk.cloud.repository")
public class RDSConfig {

    @Value("${spring.datasource.rds.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.rds.url}")
    private String url;

    @Value("${spring.datasource.rds.username}")
    private String username;

    @Value("${spring.datasource.rds.password}")
    private String password;

    @Primary // Pull in the JPA configuration via this data source's definition.
    @Bean(name = "rdsDataSource")
    public DataSource rdsDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Primary
    @Bean(name = "rdsEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder factoryBuilder,
            @Qualifier("rdsDataSource") DataSource dataSource) {
        return factoryBuilder.dataSource(dataSource)
                .packages("com.supermonk.cloud.entity")
                .persistenceUnit("supermonk").build();
    }

    @Primary
    @Bean(name = "rdsTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("rdsEntityManagerFactory") EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}