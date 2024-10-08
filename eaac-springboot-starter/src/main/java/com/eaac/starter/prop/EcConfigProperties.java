package com.eaac.starter.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The type Ec config properties.
 */
@ConfigurationProperties(prefix = "eaac.config")
@Data
public class EcConfigProperties {
    private String[] scanPackage;
    private String[] supportType;
}
