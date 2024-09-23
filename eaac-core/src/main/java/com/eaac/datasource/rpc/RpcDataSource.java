package com.eaac.datasource.rpc;

import com.eaac.config.EcConfiguration;
import com.eaac.datasource.EcConfigDataSource;
import com.eaac.datasource.http.HttpConnection;
import com.eaac.statement.HttpStatement;
import com.eaac.util.KeyUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The type Rpc data source.
 */
public class RpcDataSource extends EcConfigDataSource<RpcConnection> {
    private Map<String, RpcConnection> connectionMap = new ConcurrentHashMap<>();

    /**
     * Instantiates a new Rpc data source.
     *
     * @param ecConfiguration the ec configuration
     * @param type            the type
     */
    public RpcDataSource(EcConfiguration ecConfiguration, String type) {
        super(ecConfiguration, type);
    }

    @Override
    public RpcConnection getConnection(HttpStatement statement) {
        return connectionMap.computeIfAbsent(KeyUtil.generateConnectionKey(statement), s -> new RpcConnection(statement));
    }
}
