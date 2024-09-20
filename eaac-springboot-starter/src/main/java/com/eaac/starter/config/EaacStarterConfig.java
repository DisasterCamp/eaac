package com.eaac.starter.config;

import com.eaac.config.EcConfiguration;
import com.eaac.exec.Executor;
import com.eaac.pipe.ChannelInboundHandler;
import com.eaac.pipe.ChannelOutboundHandler;
import com.eaac.starter.exec.SpringExecutor;
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

@Configuration
@EnableAspectJAutoProxy
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class EaacStarterConfig {

    @Bean
    @ConditionalOnMissingBean(EcConfiguration.class)
    public EcConfiguration configure() {
        EcConfiguration ecConfiguration = new EcConfiguration();
        return ecConfiguration;
    }

    @Bean
    @ConditionalOnBean(EcConfiguration.class)
    @ConditionalOnMissingBean(Executor.class)
    public Executor executor(EcConfiguration ecConfiguration, ApplicationContext applicationContext) {
        SpringExecutor springExecutor = new SpringExecutor(ecConfiguration, applicationContext);
        return springExecutor;
    }


}
