package com.eaac.pipe;

import com.eaac.statement.HttpStatement;

/**
 * The interface Channel outbound handler.
 */
public interface ChannelOutboundHandler {
    /**
     * Session.
     *
     * @param context the context
     */
    void session(ChannelOutContext context);
}
