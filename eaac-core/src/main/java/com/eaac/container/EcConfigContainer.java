package com.eaac.container;

import com.eaac.api.StatementMapperClazz;
import com.eaac.api.StatementMapperMethod;
import com.eaac.config.EcConfiguration;
import com.eaac.container.http.HttpStatementContainer;
import com.eaac.exception.DupStatementException;
import com.eaac.statement.HttpStatement;
import com.eaac.util.KeyUtil;
import com.eaac.util.ReflectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The type Ec config container.
 */
public abstract class EcConfigContainer implements Container {
    /**
     * The Ec configuration.
     */
    protected EcConfiguration ecConfiguration;

    private Logger logger = LoggerFactory.getLogger(HttpStatementContainer.class);
    /**
     * The Is start.
     */
    protected volatile AtomicBoolean isStart = new AtomicBoolean(false);


    protected String type;


    public EcConfigContainer(EcConfiguration ecConfiguration, String type) {
        this.ecConfiguration = ecConfiguration;
        this.type = type;
    }

    protected void statementIn(Class<?> aClass, Map<String, Map<String, HttpStatement>> cache, Object invoker) {
        StatementMapperClazz statementMapperClazz = aClass.getAnnotation(StatementMapperClazz.class);
        //if type isn't equals invokerType, then return
        if (!statementMapperClazz.invokerType().equals(type)) return;
        Method[] methods = aClass.getDeclaredMethods();
        String[] appIds = statementMapperClazz.appIds();
        for (String appId : appIds) {
            Map<String, HttpStatement> statementMap = cache.computeIfAbsent(appId, s -> new ConcurrentHashMap<>());
            for (Method method : methods) {
                StatementMapperMethod statementMapperMethod = method.getAnnotation(StatementMapperMethod.class);
                if (Objects.nonNull(statementMapperMethod)) {
                    HttpStatement statement = new HttpStatement();
                    statement.setAppId(appId);
                    statement.setInterfaceName(aClass.getCanonicalName());
                    statement.setParameterType(ReflectionUtil.getParameterTypes(method));
                    statement.setUri(statementMapperMethod.uri());
                    statement.setInvokerType(type);
                    statement.setInterfaceMethodName(method.getName());
                    logger.info("{} initialized successfully ", statement);
                    if (statementMap.containsKey(statement.getUri()))
                        throw new DupStatementException("duplicate keys appear!!", statement.getAppId(), statement.getUri(), statement.getInvokerType());
                    if (invoker != null) {
                        HashMap<String, Object> externalParameter = new HashMap<>();
                        externalParameter.put("invoker", invoker);
                        statement.setExternalParameter(externalParameter);
                    }
                    statementMap.put(KeyUtil.generateStatementKey(statement), statement);
                } else {
                    HttpStatement statement = new HttpStatement();
                    statement.setAppId(appId);
                    statement.setInvokerType(statementMapperClazz.invokerType());
                    statement.setInterfaceName(aClass.getCanonicalName());
                    statement.setParameterType(ReflectionUtil.getParameterTypes(method));
                    statement.setUri(method.getName());
                    statement.setInterfaceMethodName(method.getName());
                    logger.info("{} initialized successfully ", statement);
                    if (statementMap.containsKey(statement.getUri()))
                        throw new DupStatementException("duplicate keys appear!!", statement.getAppId(), statement.getUri(), statement.getInvokerType());
                    if (invoker != null) {
                        HashMap<String, Object> externalParameter = new HashMap<>();
                        externalParameter.put("invoker", invoker);
                        statement.setExternalParameter(externalParameter);
                    }
                    statementMap.put(KeyUtil.generateStatementKey(statement), statement);
                }
            }
        }
    }


}
