package com.eaac.statement;

import lombok.Data;

import java.util.Map;

@Data
public class HttpStatement {
    /**
     * 分组号 不设置默认为 default
     */
    private String appId;
    /**
     * 参数类型
     */
    private String parameterType;
    /**
     * 接口方法名
     */
    private String interfaceMethodName;
    /**
     * 接口名
     */
    private String interfaceName;
    /**
     * 路由接口
     */
    private String uri;
    /**
     * 实现类型：rpc、http
     */
    private String invokerType;
    /**
     * 扩展参数
     */
    private Map<String, Object> externalParameter;

}
