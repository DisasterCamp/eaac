package com.eaac.pipe;


import java.util.LinkedList;

/**
 * The type Default pipeline.
 */
public class DefaultPipeline implements PipeLine {
    private LinkedList<ChannelInboundHandler> queueChannelInboundHandler = new LinkedList<>();
    private LinkedList<ChannelOutboundHandler> stackChannelOutboundHandler = new LinkedList<>();


    /**
     * Gets queue channel inbound handler.
     *
     * @return the queue channel inbound handler
     */
    public LinkedList<ChannelInboundHandler> getQueueChannelInboundHandler() {
        return queueChannelInboundHandler;
    }

    /**
     * Gets stack channel outbound handler.
     *
     * @return the stack channel outbound handler
     */
    public LinkedList<ChannelOutboundHandler> getStackChannelOutboundHandler() {
        return stackChannelOutboundHandler;
    }


    @Override
    public PipeLine addIn(ChannelInboundHandler channelHandler) {
        queueChannelInboundHandler.addFirst(channelHandler);
        return this;
    }

    @Override
    public PipeLine addOut(ChannelOutboundHandler channelHandler) {
        stackChannelOutboundHandler.addLast(channelHandler);
        return this;
    }

    @Override
    public PipeLine removeIn(ChannelInboundHandler channelHandler) {
        queueChannelInboundHandler.remove(channelHandler);
        return this;
    }

    @Override
    public PipeLine removeOut(ChannelOutboundHandler channelHandler) {
        stackChannelOutboundHandler.remove(channelHandler);
        return this;
    }


}
