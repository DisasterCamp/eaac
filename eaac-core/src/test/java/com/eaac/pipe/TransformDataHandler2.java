package com.eaac.pipe;

import com.eaac.statement.HttpStatement;

public class TransformDataHandler2 implements ChannelInboundHandler {

    @Override
    public void session(ChannelInContext channelInContext) {
        HttpStatement statement = channelInContext.getStatement();
        channelInContext.close();
        System.out.println("============= TransformDataHandler2 ============");
    }
}