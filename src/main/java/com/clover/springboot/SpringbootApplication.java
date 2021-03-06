package com.clover.springboot;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * spring boot 程序入口
 * 
 * @author zhangdq
 * @time 2018年3月1日 上午11:22:50
 * @Email qiang900714@126.com
 */
@SpringBootApplication
public class SpringbootApplication {
	@Bean
	@ConditionalOnMissingBean // 当容器里没有指定的 Bean 的情况下创建该对象
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		// 设置数据源
		sqlSessionFactoryBean.setDataSource(dataSource);

		// 设置mybatis的主配置文件
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource mybatisConfigXml = resolver.getResource("classpath:mybatis/mybatis-config.xml");
		sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);

		// 设置mapper映射文件
		Resource[] mapperXml;
		try {
			mapperXml = resolver.getResources("classpath:mybatis/mapper/*.xml");
			sqlSessionFactoryBean.setMapperLocations(mapperXml);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 设置别名包
		sqlSessionFactoryBean.setTypeAliasesPackage("com.clover.springboot.mapper");

		return sqlSessionFactoryBean;
	}

	@Bean
	@ConditionalOnBean(SqlSessionFactoryBean.class) // 当 SqlSessionFactoryBean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.clover.springboot.mapper");
		return mapperScannerConfigurer;
	}
}