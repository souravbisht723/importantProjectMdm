package com.example.core.demo1.oracle.entity;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.core.demo1.oracle.entity",
        entityManagerFactoryRef = "primaryEntityManagerFactory",
        transactionManagerRef = "primaryTransactionManager"
)
public class OracleDbConfig {
	
	@Autowired
	private Environment environment;
	
	    @Primary
	    @Bean(name = "primaryDataSource")
	    @ConfigurationProperties(prefix = "spring.datasource.primary")
	    public DataSource dataSource() {
	    	
	    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    	dataSource.setUrl(environment.getProperty("spring.datasource.url"));
	    	dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
	    	dataSource.setUsername(environment.getProperty("spring.datasource.username"));
	    	dataSource.setPassword(environment.getProperty("spring.datasource.password"));
	        return dataSource;
	    }

	    @Primary
	    @Bean(name = "primaryEntityManagerFactory")
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory(  ) {
	    	
	    	LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
	    	
	    	JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	    	bean.setJpaVendorAdapter(adapter);
	    	
	    	bean.setDataSource(dataSource());
	   
	    	
	    	
	    	Map<String,String> props = new HashMap<>();
	    	props.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
	    	props.put("hibernate.show_sql","true");
	    	props.put("hibernate.hbm2ddl.auto","update");
	    	
	    	bean.setJpaPropertyMap(props);
	    	bean.setPackagesToScan("com.example.core.demo1.oracle.entity");
	        return bean;
	    }

	    @Primary
	    @Bean(name = "primaryTransactionManager")
	    public PlatformTransactionManager transactionManager(
	            @Qualifier("primaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
	        return new JpaTransactionManager(entityManagerFactory);
	    }

}