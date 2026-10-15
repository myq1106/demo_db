package com.exam.demo_db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * 讲解要点：
 * 1. @SpringBootApplication 是组合注解，包含 @SpringBootConfiguration、@EnableAutoConfiguration、@ComponentScan，
 *    会自动扫描当前包及其子包下的 @Component / @Service / @Controller 等 Bean。
 * 2. @MapperScan("com.exam.demo_db.mapper") 让 MyBatis-Plus 去扫描该包下所有 Mapper 接口，
 *    并为它们生成动态代理实现类，所以 Mapper 接口不需要写 @Mapper 注解、也不需要写 XML。
 */
@SpringBootApplication
@MapperScan("com.exam.demo_db.mapper")
public class DemoDbApplication {

	public static void main(String[] args) {
		// 启动 Spring 容器（内置 Tomcat，默认 8080 端口）
		SpringApplication.run(DemoDbApplication.class, args);
	}

}
