package com.foodbird.demo;

import com.foodbird.demo.mybatis.DataRouterInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/31
 */
@Configuration
public class BeanConfig {

    @Bean
    public DataRouterInterceptor dataRouterInterceptor() {
        return new DataRouterInterceptor();
    }

}
