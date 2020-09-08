package com.betacat.starter.config;

import com.betacat.starter.properties.DemoProperties;
import com.betacat.starter.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @EnableConfigurationProperties可以把相同前缀的配置信息通过配置项名称映射成实体类
 * 这样，我们就能将以demo为前缀的配置项拿到了
 */

@Configuration
@EnableConfigurationProperties(DemoProperties.class)
@ConditionalOnProperty(
        prefix = "demo",
        name = "isopen",
        havingValue ="true"
)
public class DemoConfig {
    @Autowired
    private DemoProperties demoProperties;

    @Bean
    public DemoService demoService(){
        return new DemoService(demoProperties.getSayWhat(),demoProperties.getToWho());
    }
}
