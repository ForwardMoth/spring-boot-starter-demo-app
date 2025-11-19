package com.aop.logging_starter.config;

import com.aop.logging_starter.aspect.LoggingAspect;
import com.aop.logging_starter.properties.LoggingProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(LoggingProperties.class)
public class LoggingConfiguration {

    @Bean
    @ConditionalOnProperty(name = "app.logging.enabled", havingValue = "true", matchIfMissing = true)
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

}
