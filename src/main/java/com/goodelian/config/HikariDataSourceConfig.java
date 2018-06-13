package com.goodelian.config;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

/**
 * 数据库源配置
 * 
 * @author sysu
 * @version 2017/6/12 18:14
 */
@Configuration
public class HikariDataSourceConfig {

	@Bean(name = "primaryHikariConfig")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}


	@Primary
	@Bean(name = "primaryDataSource", destroyMethod = "close")
	public HikariDataSource dataSource(@Qualifier("primaryHikariConfig") HikariConfig hikariConfig) {
		return new HikariDataSource(hikariConfig);
	}

	@Primary
	@Bean(name = "primaryJdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(
			@Qualifier("primaryDataSource") HikariDataSource miniworldHomeDataSource) {
		return new JdbcTemplate(miniworldHomeDataSource);
	}





}
