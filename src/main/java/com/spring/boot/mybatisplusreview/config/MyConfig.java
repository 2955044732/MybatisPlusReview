package com.spring.boot.mybatisplusreview.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.MyBatisExceptionTranslator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther qwh
 * @create 2023-05-2023/5/18 22:56
 */
@Configuration
@MapperScan("com.spring.boot.mybatisplusreview.mapper")
public class MyConfig {
  @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){

      MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
      //添加分页插件
      interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
      //添加乐观锁
      interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
      return interceptor;
  }
}
