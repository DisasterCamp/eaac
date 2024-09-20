package com.eaac.pipe;

/**
 * The interface Pipe line.
 */
public interface PipeLine {
    /**
     * Add in pipe line.
     *
     * @param channelHandler the channel handler
     * @return the pipe line
     */
    PipeLine addIn(ChannelInboundHandler channelHandler);

    /**
     * Add out pipe line.
     *
     * @param channelHandler the channel handler
     * @return the pipe line
     */
    PipeLine addOut(ChannelOutboundHandler channelHandler);

    /**
     * Remove in pipe line.
     *
     * @param channelHandler the channel handler
     * @return the pipe line
     */
    PipeLine removeIn(ChannelInboundHandler channelHandler);

    /**
     * Remove out pipe line.
     *
     * @param channelHandler the channel handler
     * @return the pipe line
     */
    PipeLine removeOut(ChannelOutboundHandler channelHandler);

}
