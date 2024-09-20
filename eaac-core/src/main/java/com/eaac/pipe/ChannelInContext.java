package com.eaac.pipe;

/**
 * The interface Channel in context.
 */
public interface ChannelInContext extends Context{
    /**
     * Write and flush.
     *
     * @param args the args
     */
    void writeAndFlush(Object[] args);

    boolean isClose();

    /**
     * Get args object [ ].
     *
     * @return the object [ ]
     */
    Object[] getArgs();
}
