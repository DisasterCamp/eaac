package com.eaac.pipe;

public class TransformDataHandler2 implements ChannelInboundHandler {

    @Override
    public void session(ChannelInContext channelInContext) {
        System.out.println("============= TransformDataHandler2 ============");
    }
}