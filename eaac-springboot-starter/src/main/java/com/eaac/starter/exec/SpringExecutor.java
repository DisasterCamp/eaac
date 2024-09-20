package com.eaac.starter.exec;

import com.eaac.api.StatementMapperClazz;
import com.eaac.config.EcConfiguration;
import com.eaac.container.Container;
import com.eaac.datasource.Connection;
import com.eaac.datasource.DataSource;
import com.eaac.datasource.SpiDataSourceFactory;
import com.eaac.exception.NoFoundContainerException;
import com.eaac.exception.NoFoundStatementException;
import com.eaac.exec.BaseExecutor;
import com.eaac.statement.HttpStatement;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * The type Spring executor.
 */
public class SpringExecutor extends BaseExecutor {
    private ApplicationContext applicationContext;
    private Class[] cls = new Class[]{EcConfiguration.class, String.class, ApplicationContext.class};

    /**
     * Instantiates a new Spring executor.
     *
     * @param ecConfiguration    the ec configuration
     * @param applicationContext the application context
     */
    public SpringExecutor(EcConfiguration ecConfiguration, ApplicationContext applicationContext) {
        super(ecConfiguration);
        this.applicationContext = applicationContext;
    }

    /**
     * Instantiates a new Base executor.
     *
     * @param ecConfiguration the ec configuration
     */
    public SpringExecutor(EcConfiguration ecConfiguration) {
        super(ecConfiguration);
    }

    @Override
    public Object exec(String type, String appId, String uri, Object... params) throws Exception {
        SpiDataSourceFactory spiDataSourceFactory = new SpiDataSourceFactory(ecConfiguration);
        Object[] ars = new Object[]{ecConfiguration, type, applicationContext};
        Container container = ecConfiguration.getContainer(type, ars, cls);
        if (container == null) throw new NoFoundContainerException("no found container", type);
        HttpStatement statement = container.getStatement(appId, uri);
        if (statement == null) throw new NoFoundStatementException("no found statement", appId, uri, type);
        DataSource dataSource = spiDataSourceFactory.getDataSource(type, ars, cls);
        if (dataSource == null) throw new NoFoundContainerException("no found dataSource", statement.getInvokerType());
        Connection connection = dataSource.getConnection(statement);
        String parameterType = statement.getParameterType();
        String[] parameterTypes = StringUtils.isEmpty(parameterType) ? null : parameterType.split(",");
        Object[] args = postHandler(params, statement);
        Object execute = connection.execute(statement.getInterfaceName(), statement.getInterfaceMethodName(), parameterTypes, new String[]{"ignore"}, args);
        execute = afterHandler(statement, execute);
        return execute;
    }
}
