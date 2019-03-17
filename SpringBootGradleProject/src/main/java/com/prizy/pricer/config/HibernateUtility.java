package com.prizy.pricer.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.prizy.pricer.dao"})
@EnableTransactionManagement
public class HibernateUtility {

	// Change the below based on the DBMS you choose
		private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/prizy";
		private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
		private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
		private final static String DATABASE_USERNAME = "PrizyUser";
		private final static String DATABASE_PASSWORD = "password";
		
		// dataSource bean will be available
		@Bean
		public DataSource getDataSource() {
			
			
			BasicDataSource dataSource = new BasicDataSource();
			
			// Providing the database connection information
			dataSource.setDriverClassName(DATABASE_DRIVER);
			dataSource.setUrl(DATABASE_URL);
			dataSource.setUsername(DATABASE_USERNAME);
			dataSource.setPassword(DATABASE_PASSWORD);
					
			
			return dataSource;
			
		}
		
		// sessionFactory bean will be available
		
		@Bean
		public SessionFactory getSessionFactory(DataSource dataSource) {
			System.out.println("---------------------------22222-------------------------------");
			LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
			
			builder.addProperties(getHibernateProperties());
			builder.scanPackages("com.prizy.pricer.dao");
//			System.out.println("-------builder.buildSessionFactory()---------"+builder.buildSessionFactory().isOpen());
			return builder.buildSessionFactory();
			
		}

		
		
		// All the hibernate properties will be returned in this method	
		private Properties getHibernateProperties() {
			
			Properties properties = new Properties();
			
			
			properties.put("hibernate.dialect", DATABASE_DIALECT);		
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.format_sql", "true");
			properties.put("hibernate.id.new_generator_mappings","false");
			
			//properties.put("hibernate.hbm2ddl.auto", "create");
			
			
			return properties;
		}
		
		// transactionManager bean
		@Bean
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}
}
