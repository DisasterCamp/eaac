package com.eaac.exec;

import com.eaac.config.EcConfiguration;
import com.eaac.pipe.*;
import com.eaac.statement.HttpStatement;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

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
     * Instantiates a new Base executor.
     *
     * @param ecConfiguration the ec configuration
     */
    public BaseExecutor(EcConfiguration ecConfiguration) {
        this.ecConfiguration = ecConfiguration;
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
}
