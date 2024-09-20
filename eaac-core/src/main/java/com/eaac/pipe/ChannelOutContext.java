package com.eaac.pipe;

public interface ChannelOutContext extends Context{
    void writeAndFlush(Object result);

    Object getResult();
}
