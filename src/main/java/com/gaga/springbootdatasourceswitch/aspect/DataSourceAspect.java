package com.gaga.springbootdatasourceswitch.aspect;

import com.gaga.springbootdatasourceswitch.config.ThreadLocalDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 数据源切换切面
 * @Author fuGaga
 * @Date 2021/4/22 16:03
 * @Version 1.0
 */

@Aspect
@Component
@Slf4j
public class DataSourceAspect {

    @Pointcut(value = "@annotation(DataSource)")
    public void pointcut(){}

//    @Around(value = "pointcut() && @annotation(dataSource)")
//    public void around(ProceedingJoinPoint point, DataSource dataSource) throws Throwable {
//        ThreadLocalDataSource.setDbKey(dataSource.name());
//        log.info("设置数据源------ {}", dataSource.name());
//
//        point.proceed();
//
//        ThreadLocalDataSource.removeKey();
//        log.info("清除数据源------ {}", dataSource.name());
//    }

    @Before("pointcut() && @annotation(dataSource)")
    public void before(DataSource dataSource){
        ThreadLocalDataSource.setDbKey(dataSource.name());
        log.info("设置数据源------ {}", dataSource.name());
    }


    @After("pointcut() && @annotation(dataSource)")
    public void after(DataSource dataSource){
        ThreadLocalDataSource.removeKey();
        log.info("清除数据源------ {}", dataSource.name());
    }
}
