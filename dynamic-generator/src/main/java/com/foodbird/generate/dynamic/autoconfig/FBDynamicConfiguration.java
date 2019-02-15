package com.foodbird.generate.dynamic.autoconfig;

import com.foodbird.generate.dynamic.component.FBBeanRegistrator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/18
 */
@Configuration
public class FBDynamicConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "foodbird.dynamic", value = "enabled", matchIfMissing = true)
    public FBBeanRegistrator beanRegistrator() {
        return new FBBeanRegistrator();
    }

}
