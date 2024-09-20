package com.eaac.pipe;

import com.eaac.statement.HttpStatement;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The type Default channel out context.
 */
public class DefaultChannelOutContext implements ChannelOutContext {
    private HttpStatement httpStatement;
    private Object result;
    private AtomicBoolean isClose;

    /**
     * Instantiates a new Default channel out context.
     *
     * @param httpStatement the http statement
     * @param result        the result
     * @param isClose       the is close
     */
    public DefaultChannelOutContext(HttpStatement httpStatement, Object result, AtomicBoolean isClose) {
        this.httpStatement = httpStatement;
        this.result = result;
        this.isClose = isClose;
    }

    @Override
    public void writeAndFlush(Object result) {
        this.result = result;
    }

    @Override
    public boolean isClose() {
        return isClose.get();
    }

    @Override
    public Object getResult() {
        return result;
    }

    @Override
    public void close() {
        isClose.set(true);
    }

    @Override
    public HttpStatement getStatement() {
        return httpStatement;
    }
}
