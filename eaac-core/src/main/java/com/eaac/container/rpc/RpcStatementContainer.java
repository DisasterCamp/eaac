package com.eaac.container.rpc;

import com.eaac.config.EcConfiguration;
import com.eaac.container.EcConfigContainer;
import com.eaac.statement.HttpStatement;

public class RpcStatementContainer extends EcConfigContainer {


    public RpcStatementContainer(EcConfiguration ecConfiguration, String type) {
        super(ecConfiguration, type);
    }

    @Override
    public HttpStatement getStatement(String appId, String uri) {
        return null;
    }
}
