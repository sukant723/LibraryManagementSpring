package com.jocata.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import com.jocata.clip.utils.SchemaLocation;


@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class HibernateConfiguration {

	@Autowired
	public DataSource dataSource;
	
	@Autowired
	public CLIPAppProperties clipAppProperties;
	
	
	 @Bean
	  public LocalSessionFactoryBean sessionFactory() {
		  
	    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	    sessionFactoryBean.setDataSource(dataSource);
	    sessionFactoryBean.setPackagesToScan(clipAppProperties.getHibernatePackagesToScan());
	    
	    Properties hibernateProperties = new Properties();
	    hibernateProperties.put("hibernate.dialect", clipAppProperties.getDialect());
	    hibernateProperties.put("hibernate.show_sql", clipAppProperties.getShowSql());
	    hibernateProperties.put("hibernate.format_sql", clipAppProperties.getShowSql());
	    hibernateProperties.put("hibernate.id.new_generator_mappings", clipAppProperties.getHibernateIdNewGeneratorMappings());
//	    hibernateProperties.put("hibernate.default_schema",SchemaLocation.SCHEMA);
	    hibernateProperties.put("hibernate.hbm2ddl.auto", "none");
	    hibernateProperties.put("org.hibernate.envers.store_data_at_delete", true);
	
	    sessionFactoryBean.setHibernateProperties(hibernateProperties);
	    
	    return sessionFactoryBean;
	  }
	 
	  @Bean
	  public HibernateTransactionManager transactionManager() {
		  HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	    transactionManager.setSessionFactory(sessionFactory().getObject());
	    return transactionManager;
	  }

}
