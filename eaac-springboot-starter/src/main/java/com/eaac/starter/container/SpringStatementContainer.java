package com.eaac.starter.container;

import com.eaac.api.StatementMapperClazz;
import com.eaac.config.EcConfiguration;
import com.eaac.container.EcConfigContainer;
import com.eaac.container.http.HttpStatementContainer;
import com.eaac.statement.HttpStatement;
import com.eaac.util.KeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class SpringStatementContainer extends EcConfigContainer {
    private ApplicationContext applicationContext;
    private Logger logger = LoggerFactory.getLogger(HttpStatementContainer.class);
    private Map<String, Map<String, HttpStatement>> typeStatement = new ConcurrentHashMap<>();

    public SpringStatementContainer(EcConfiguration ecConfiguration, String type, ApplicationContext applicationContext) {
        super(ecConfiguration, type);
        this.applicationContext = applicationContext;
        init();
    }

    @Override
    public HttpStatement getStatement(String appId, String uri) {
        Map<String, HttpStatement> httpStatementMap = typeStatement.get(appId);
        if (Objects.isNull(httpStatementMap) || !httpStatementMap.containsKey(KeyUtil.generateStatementKey(uri, type))) return null;
        return typeStatement.get(appId).get(KeyUtil.generateStatementKey(uri, type));
    }

    @Override
    public void init() {
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(StatementMapperClazz.class);
        for (Map.Entry<String, Object> entry : beansWithAnnotation.entrySet()) {
            Object invoker = entry.getValue();
            Class<?> aClass = invoker.getClass();
            if (aClass.isInterface()) {
                logger.warn("{},StatementMapperClazz cannot be used with Interface", aClass.getName());
                continue;
            }
            statementIn(aClass, typeStatement, invoker);
        }
        super.init();
    }
}

