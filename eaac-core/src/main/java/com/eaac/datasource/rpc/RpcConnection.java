package com.eaac.datasource.rpc;

import com.eaac.datasource.Connection;
import com.eaac.statement.HttpStatement;

/**
 * The type Rpc connection.
 */
public class RpcConnection implements Connection {
    private HttpStatement httpStatement;

    /**
     * Instantiates a new Rpc connection.
     *
     * @param httpStatement the http statement
     */
    public RpcConnection(HttpStatement httpStatement) {
        this.httpStatement = httpStatement;
    }
    @Override
    public Object execute(String interfaceName, String method, String[] parameterTypes, String[] parameterNames, Object[] args) throws Exception {
        //TODO rpc method
        return null;
    }
}
