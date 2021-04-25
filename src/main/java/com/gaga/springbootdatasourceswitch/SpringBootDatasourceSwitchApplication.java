package com.gaga.springbootdatasourceswitch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.gaga.springbootdatasourceswitch.dao")
public class SpringBootDatasourceSwitchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDatasourceSwitchApplication.class, args);
    }

}
