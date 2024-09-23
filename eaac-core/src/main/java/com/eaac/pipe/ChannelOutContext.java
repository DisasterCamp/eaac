package com.eaac.pipe;

/**
 * The interface Channel out context.
 */
public interface ChannelOutContext extends Context{
    /**
     * Write and flush.
     *
     * @param result the result
     */
    void writeAndFlush(Object result);

    /**
     * Gets result.
     *
     * @return the result
     */
    Object getResult();
}
