package com.eaac.starter.datasource;

import com.eaac.datasource.Connection;
import com.eaac.statement.HttpStatement;
import com.eaac.util.ReflectionUtil;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;
import java.util.Map;

public class SpringConnection implements Connection {
    private HttpStatement httpStatement;
    private ApplicationContext applicationContext;

    public SpringConnection(HttpStatement httpStatement, ApplicationContext applicationContext) {
        this.httpStatement = httpStatement;
        this.applicationContext = applicationContext;
    }

    @Override
    public Object execute(String interfaceName, String method, String[] parameterTypes, String[] parameterNames, Object[] args) throws Exception {
        Map<String, Object> externalParameter = httpStatement.getExternalParameter();
        Object invoker = externalParameter.get("invoker");
        Class<?> aClass = Class.forName(interfaceName);
        Method invMethod = aClass.getMethod(method, ReflectionUtil.findParameterTypesClazz(parameterTypes));
        return invMethod.invoke(invoker, args);
    }
}
