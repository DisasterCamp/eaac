package com.eaac.pipe;


/**
 * The interface Channel inbound handler.
 */
public interface ChannelInboundHandler {
    /**
     * Session.
     *
     * @param channelInContext the channel in context
     */
    void session(ChannelInContext channelInContext);
}
