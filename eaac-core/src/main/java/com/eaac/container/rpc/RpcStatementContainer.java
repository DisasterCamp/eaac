package com.eaac.container.rpc;

import com.eaac.config.EcConfiguration;
import com.eaac.container.EcConfigContainer;
import com.eaac.statement.HttpStatement;

/**
 * The type Rpc statement container.
 */
public class RpcStatementContainer extends EcConfigContainer {


    /**
     * Instantiates a new Rpc statement container.
     *
     * @param ecConfiguration the ec configuration
     * @param type            the type
     */
    public RpcStatementContainer(EcConfiguration ecConfiguration, String type) {
        super(ecConfiguration, type);
    }

    @Override
    public HttpStatement getStatement(String appId, String uri) {
        return null;
    }
}
