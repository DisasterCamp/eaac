package com.eaac.starter.config;

import com.eaac.config.EcConfiguration;
import com.eaac.exec.Executor;
import com.eaac.pipe.ChannelInboundHandler;
import com.eaac.pipe.ChannelOutboundHandler;
import com.eaac.starter.exec.SpringExecutor;
import com.eaac.starter.prop.EcConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.Ordered;

import java.util.Map;

/**
 * The type Eaac starter config.
 */
@Configuration
@EnableAspectJAutoProxy
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
@EnableConfigurationProperties(EcConfigProperties.class)
public class EaacStarterConfig {

    /**
     * Configure ec configuration.
     *
     * @param ecConfigProperties the ec config properties
     * @return the ec configuration
     */
    @Bean
    @ConditionalOnMissingBean(EcConfiguration.class)
    public EcConfiguration configure(EcConfigProperties ecConfigProperties) {
        EcConfiguration ecConfiguration = new EcConfiguration(ecConfigProperties.getScanPackage(), ecConfigProperties.getSupportType());
        return ecConfiguration;
    }

    /**
     * Executor executor.
     *
     * @param ecConfiguration    the ec configuration
     * @param applicationContext the application context
     * @return the executor
     */
    @Bean
    @ConditionalOnBean(EcConfiguration.class)
    @ConditionalOnMissingBean(Executor.class)
    public Executor executor(EcConfiguration ecConfiguration, ApplicationContext applicationContext) {
        SpringExecutor springExecutor = new SpringExecutor(ecConfiguration, applicationContext);
        return springExecutor;
    }


}
