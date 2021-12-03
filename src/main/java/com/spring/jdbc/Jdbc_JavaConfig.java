package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
public class Jdbc_JavaConfig {

	@Bean(name= {"ds"})
	public DataSource getDataSource()
	{
		DriverManagerDataSource obj=new DriverManagerDataSource();
		obj.setDriverClassName("com.mysql.cj.jdbc.Driver");
		obj.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		obj.setUsername("root");
		obj.setPassword("root");
		return obj;
   }
	
	@Bean(name= {"jdbcTemplate"})
	public JdbcTemplate getJdbcTemplate()
	{
		JdbcTemplate obj=new JdbcTemplate();
		obj.setDataSource(getDataSource());
		return null;
		
	}
	
	@Bean(name= {"studentDaoImpl"})
	public StudentDao getStudentDao()
	{
		StudentDaoImpl obj=new StudentDaoImpl();
		obj.setJdbcTemplate(getJdbcTemplate());
		return obj;
	}
}
