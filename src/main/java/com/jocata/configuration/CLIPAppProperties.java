package com.jocata.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

 

@Configuration //@Component 
// @Profile({ "dev", "staging", "prod" })
public class CLIPAppProperties {

	@Value("${hibernate.dialect}")
	private String dialect;

	@Value("${hibernate.show_sql}")    
	private String showSql;

	@Value("${entitymanager.packagesToScan}")
	private String hibernatePackagesToScan;

	@Value("hibernate.id.new_generator_mappings")
	private String hibernateIdNewGeneratorMappings;

	public String getDialect() {
		return dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

	public String getShowSql() {
		return showSql;
	}

	public void setShowSql(String showSql) {
		this.showSql = showSql;
	}

	public String getHibernatePackagesToScan() {
		return hibernatePackagesToScan;
	}

	public void setHibernatePackagesToScan(String hibernatePackagesToScan) {
		this.hibernatePackagesToScan = hibernatePackagesToScan;
	}

	public String getHibernateIdNewGeneratorMappings() {
		return hibernateIdNewGeneratorMappings;
	}

	public void setHibernateIdNewGeneratorMappings(String hibernateIdNewGeneratorMappings) {
		this.hibernateIdNewGeneratorMappings = hibernateIdNewGeneratorMappings;
	}

	
}
