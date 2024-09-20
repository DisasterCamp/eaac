package com.eaac.starter.datasource;

import com.eaac.config.EcConfiguration;
import com.eaac.datasource.Connection;
import com.eaac.datasource.EcConfigDataSource;
import com.eaac.datasource.http.HttpConnection;
import com.eaac.statement.HttpStatement;
import com.eaac.util.KeyUtil;
import org.springframework.context.ApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SpringDataSource extends EcConfigDataSource {
    private ApplicationContext applicationContext;
    private Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public SpringDataSource(EcConfiguration ecConfiguration, String type, ApplicationContext applicationContext) {
        super(ecConfiguration, type);
        this.applicationContext = applicationContext;
    }

    @Override
    public Connection getConnection(HttpStatement statement) {
        return connectionMap.computeIfAbsent(KeyUtil.generateConnectionKey(statement), s ->  new SpringConnection(statement,applicationContext));
    }
}
