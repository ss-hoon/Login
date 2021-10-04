package com.app.login.sys.database;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(annotationClass = Mapper.class, sqlSessionFactoryRef = "sqlSessionFactory", basePackages = "com.app.*.biz")
public class DatasourceConfig {

	@Autowired
	ApplicationContext context;
//
//	@Bean
//	@ConfigurationProperties(prefix = "spring.datasource.hikari")
//	public HikariConfig hiskariConfigPrimary() {
//		return new HikariConfig();
//	}
//
//	@Primary
//	@Bean(name = "dataSource")
//	public DataSource dataSource() {
//		HikariConfig hc = hiskariConfigPrimary();
//		return new HikariDataSource(hc);
//	}

	@Primary
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean(@Autowired @Qualifier("dataSource") DataSource dataSource,
			ApplicationContext applicationContext) throws Exception {

		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
		factoryBean.setMapperLocations(applicationContext.getResources("classpath*:mappers/**/*.xml"));
		return factoryBean.getObject();
	}

	@Primary
	@Bean(name = "sqlSession")
	public SqlSessionTemplate sqlSession(
			@Autowired @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Primary
	@Bean(name = "transactionManager")
	public DataSourceTransactionManager transactionManager(@Autowired @Qualifier("dataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}