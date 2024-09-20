package com.eaac.exec;

import com.eaac.config.EcConfiguration;
import com.eaac.container.Container;
import com.eaac.datasource.Connection;
import com.eaac.datasource.DataSource;
import com.eaac.datasource.SpiDataSourceFactory;
import com.eaac.exception.NoFoundContainerException;
import com.eaac.exception.NoFoundStatementException;
import com.eaac.pipe.*;
import com.eaac.statement.HttpStatement;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;

/**
 * The type Simple executor.
 */
public class SimpleExecutor extends BaseExecutor {

    private Class[] cls = new Class[]{EcConfiguration.class, String.class};

    /**
     * Instantiates a new Simple executor.
     *
     * @param ecConfiguration the ec configuration
     */
    public SimpleExecutor(EcConfiguration ecConfiguration) {
        super(ecConfiguration);
    }


    @Override
    public Object exec(String type, String appId, String uri, Object... params) throws Exception {
        SpiDataSourceFactory spiDataSourceFactory = new SpiDataSourceFactory(ecConfiguration);
        Object[] ars = new Object[]{ecConfiguration, type};
        Container container = ecConfiguration.getContainer(type, ars, cls);
        if (container == null) throw new NoFoundContainerException("no found container", type);
        HttpStatement statement = container.getStatement(appId, uri);
        if (statement == null) throw new NoFoundStatementException("no found statement", appId, uri, type);
        DataSource dataSource = spiDataSourceFactory.getDataSource(type, ars,cls);
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
