package com.eaac.pipe;

public class LogDataHandler2 implements ChannelOutboundHandler{
    @Override
    public void session(ChannelOutContext context) {
        System.out.println("============= LogDataHandler2 ============");
    }
}
