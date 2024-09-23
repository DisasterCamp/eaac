package com.eaac.container.http;

import com.eaac.api.StatementMapperClazz;
import com.eaac.api.StatementMapperMethod;
import com.eaac.config.EcConfiguration;
import com.eaac.container.EcConfigContainer;
import com.eaac.exception.DupStatementException;
import com.eaac.exception.IllegalTypeOnAnno;
import com.eaac.statement.HttpStatement;
import com.eaac.util.KeyUtil;
import com.eaac.util.ReflectionUtil;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * The type Http statement container.
 */
public class HttpStatementContainer extends EcConfigContainer {
    private Logger logger = LoggerFactory.getLogger(HttpStatementContainer.class);
    private Map<String, Map<String, HttpStatement>> typeStatement = new ConcurrentHashMap<>();


    /**
     * Instantiates a new Http statement container.
     *
     * @param ecConfiguration the ec configuration
     * @param type            the type
     */
    public HttpStatementContainer(EcConfiguration ecConfiguration, String type) {
        super(ecConfiguration, type);
        init();
    }


    @Override
    public HttpStatement getStatement(String appId, String uri) {
        Map<String, HttpStatement> httpStatementMap = typeStatement.get(appId);
        if (Objects.isNull(httpStatementMap) || !httpStatementMap.containsKey(KeyUtil.generateStatementKey(uri, type)))
            return null;
        return typeStatement.get(appId).get(KeyUtil.generateStatementKey(uri, type));
    }

    /**
     * Init.
     */
    @Override
    public void init() {
        Reflections reflections = new Reflections(ecConfiguration.getScanPackage() == null ?
                "com.eaac" : ecConfiguration.getScanPackage());
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(StatementMapperClazz.class, true);
        for (Class<?> aClass : typesAnnotatedWith) {
            if (aClass.isInterface()) {
                logger.warn("{},StatementMapperClazz cannot be used with Interface", aClass.getName());
                continue;
            }
            statementIn(aClass, typeStatement, null);
        }
        super.init();
    }


}
