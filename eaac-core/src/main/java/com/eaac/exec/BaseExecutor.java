package com.eaac.exec;

import com.eaac.config.EcConfiguration;
import com.eaac.datasource.Connection;
import com.eaac.datasource.SpiDataSourceFactory;
import com.eaac.pipe.*;
import com.eaac.statement.HttpStatement;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The type Base executor.
 */
public abstract class BaseExecutor implements Executor {
    private Logger logger = LoggerFactory.getLogger(BaseExecutor.class);

    /**
     * The Ec configuration.
     */
    protected EcConfiguration ecConfiguration;

    /**
     * The Spi data source factory.
     */
    protected SpiDataSourceFactory spiDataSourceFactory;


    /**
     * Instantiates a new Base executor.
     *
     * @param ecConfiguration the ec configuration
     */
    public BaseExecutor(EcConfiguration ecConfiguration) {
        this.ecConfiguration = ecConfiguration;
        this.spiDataSourceFactory = new SpiDataSourceFactory(ecConfiguration);
    }

    /**
     * Instantiates a new Base executor.
     *
     * @param ecConfiguration      the ec configuration
     * @param spiDataSourceFactory the spi data source factory
     */
    public BaseExecutor(EcConfiguration ecConfiguration, SpiDataSourceFactory spiDataSourceFactory) {
        this.ecConfiguration = ecConfiguration;
        this.spiDataSourceFactory = spiDataSourceFactory;
    }

    /**
     * After handler object.
     *
     * @param statement the statement
     * @param execute   the execute
     * @return the object
     */
    protected Object afterHandler(HttpStatement statement, Object execute) {
        ChannelOutContext channelOutContext = null;
        for (ChannelOutboundHandler channelOutboundHandler : ecConfiguration.getStackChannelOutboundHandler()) {
            if (channelOutContext == null)
                channelOutContext = new DefaultChannelOutContext(statement, execute, new AtomicBoolean(false));
            channelOutboundHandler.session(channelOutContext);
            if (channelOutContext.isClose()) {
                execute = channelOutContext.getResult();
                break;
            }
        }
        return execute;
    }

    /**
     * Post handler object [ ].
     *
     * @param params    the params
     * @param statement the statement
     * @return the object [ ]
     */
    protected Object[] postHandler(Object[] params, HttpStatement statement) {
        Object[] args = params;
        ChannelInContext channelInContext = null;
        for (ChannelInboundHandler channelInboundHandler : ecConfiguration.getQueueChannelInboundHandler()) {
            if (channelInContext == null)
                channelInContext = new DefaultChannelInContext(statement, new AtomicBoolean(false), params);
            channelInboundHandler.session(channelInContext);
            if (channelInContext.isClose()) {
                args = channelInContext.getArgs();
                break;
            }
        }
        return args;
    }

    /**
     * Do exec object.
     *
     * @param params     the params
     * @param statement  the statement
     * @param connection the connection
     * @return the object
     * @throws Exception the exception
     */
    protected Object doExec(Object[] params, HttpStatement statement, Connection connection) throws Exception {
        String[] parameterTypes = StringUtils.isEmpty(statement.getParameterType()) ? null : statement.getParameterType().split(",");
        Object[] args = postHandler(params, statement);
        Object execute = connection.execute(statement.getInterfaceName(), statement.getInterfaceMethodName(), parameterTypes, new String[]{"ignore"}, args);
        execute = afterHandler(statement, execute);
        return execute;
    }
}
