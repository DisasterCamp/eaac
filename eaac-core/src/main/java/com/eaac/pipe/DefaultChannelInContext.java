package com.eaac.pipe;

import com.eaac.statement.HttpStatement;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The type Default channel in context.
 */
public class DefaultChannelInContext implements ChannelInContext {
    private HttpStatement httpStatement;
    private AtomicBoolean isClose;
    private Object[] args;

    /**
     * Instantiates a new Default channel in context.
     *
     * @param httpStatement the http statement
     * @param isClose       the is close
     * @param args          the args
     */
    public DefaultChannelInContext(HttpStatement httpStatement, AtomicBoolean isClose, Object[] args) {
        this.httpStatement = httpStatement;
        this.isClose = isClose;
        this.args = args;
    }

    @Override
    public void close() {
        isClose.set(true);
    }


    @Override
    public HttpStatement getStatement() {
        return httpStatement;
    }

    @Override
    public void writeAndFlush(Object[] args) {
        this.args = args;
    }

    @Override
    public boolean isClose() {
        return isClose.get();
    }

    @Override
    public Object[] getArgs() {
        return args;
    }
}
