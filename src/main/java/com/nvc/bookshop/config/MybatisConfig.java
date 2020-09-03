package com.nvc.bookshop.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.nvc.bookshop.mapper")
public class MybatisConfig {
}
