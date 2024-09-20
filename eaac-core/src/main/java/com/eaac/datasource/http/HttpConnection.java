package com.eaac.datasource.http;

import com.eaac.datasource.Connection;
import com.eaac.statement.HttpStatement;
import com.eaac.util.ReflectionUtil;

import java.lang.reflect.Method;

/**
 * The type Http connection.
 */
public class HttpConnection implements Connection {
    private HttpStatement httpStatement;

    /**
     * Instantiates a new Http connection.
     *
     * @param httpStatement the http statement
     */
    public HttpConnection(HttpStatement httpStatement) {
        this.httpStatement = httpStatement;
    }

    @Override
    public Object execute(String interfaceName, String method, String[] parameterTypes, String[] parameterNames, Object[] args) throws Exception {
        Class<?> aClass = Class.forName(interfaceName);
        Object object = aClass.newInstance();
        Method invMethod = aClass.getMethod(method, ReflectionUtil.findParameterTypesClazz(parameterTypes));
        return invMethod.invoke(object, args);
    }
}
