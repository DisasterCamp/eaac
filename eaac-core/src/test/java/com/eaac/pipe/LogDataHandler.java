package com.eaac.pipe;

import com.eaac.statement.HttpStatement;

public class LogDataHandler implements ChannelOutboundHandler{
    @Override
    public void session(ChannelOutContext context) {
        System.out.println("============= LogDataHandler ============");
    }
}
