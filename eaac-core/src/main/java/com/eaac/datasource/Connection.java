package com.eaac.datasource;

/**
 * The interface Connection.
 */
public interface Connection {
    /**
     * Execute object.
     *
     * @param interfaceName  the interface name
     * @param method         the method
     * @param parameterTypes the parameter types
     * @param parameterNames the parameter names
     * @param args           the args
     * @return the object
     * @throws Exception the exception
     */
    Object execute(String interfaceName,String method, String[] parameterTypes, String[] parameterNames, Object[] args) throws Exception;
}
