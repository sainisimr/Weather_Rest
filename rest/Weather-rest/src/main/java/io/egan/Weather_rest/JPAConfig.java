package io.egan.Weather_rest;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:application.properties")
public class JPAConfig {

	@Autowired
	private Environment en;

	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setDataSource(getdataSource());
		emf.setPackagesToScan("io.egan.Weather_rest.Entity");
		emf.setJpaProperties(jpaProperties());
		return emf;

	}

	@Bean
	public PlatformTransactionManager transmanager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	public Properties jpaProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", en.getProperty("hibernate.hbm2ddl"));
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.show_sql", en.getProperty("hibernate.sw_sql"));
		props.setProperty("hibernate.format_sql", en.getProperty("hibernate.ft_sql"));
		return props;
	}

	@Bean
	public DataSource getdataSource() {
		DriverManagerDataSource dms = new DriverManagerDataSource();
		dms.setDriverClassName("com.mysql.jdbc.Driver");
		dms.setUrl(en.getProperty("db.url"));
		dms.setUsername(en.getProperty("db.user"));
		dms.setPassword(en.getProperty("db.password", "root"));
		return dms;
	}

}
