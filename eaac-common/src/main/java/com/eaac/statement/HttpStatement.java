package com.eaac.statement;

import lombok.Data;

import java.util.Map;

/**
 * The type Http statement.
 */
@Data
public class HttpStatement {

    private String appId;
    private String parameterType;
    private String interfaceMethodName;
    private String interfaceName;
    private String uri;
    private String invokerType;
    private Map<String, Object> externalParameter;

}
