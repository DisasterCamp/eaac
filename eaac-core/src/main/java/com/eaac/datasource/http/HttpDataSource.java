package com.eaac.datasource.http;

import com.eaac.config.EcConfiguration;
import com.eaac.datasource.Connection;
import com.eaac.datasource.EcConfigDataSource;
import com.eaac.extension.SPI;
import com.eaac.statement.HttpStatement;
import com.eaac.statement.Statement;
import com.eaac.util.KeyUtil;
import com.eaac.util.SimpleTypeUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;


/**
 * The type Http data source.
 *
 * @author <a href="mailto:"
 * @date 2024 /09/17
 * @description http data source
 * @since 1.0
 */
public class HttpDataSource extends EcConfigDataSource<HttpConnection> {
    private Map<String, HttpConnection> connectionMap = new ConcurrentHashMap<>();


    public HttpDataSource(EcConfiguration ecConfiguration, String type) {
        super(ecConfiguration, type);
    }

    @Override
    public HttpConnection getConnection(HttpStatement statement) {
        return connectionMap.computeIfAbsent(KeyUtil.generateConnectionKey(statement), s ->  new HttpConnection(statement));
    }

}
