package com.eaac.pipe;

import com.eaac.statement.HttpStatement;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class TransformDataHandler implements ChannelInboundHandler {

    @Override
    public void session(ChannelInContext channelInContext) {
        System.out.println("============= TransformDataHandler ============");
    }
}
