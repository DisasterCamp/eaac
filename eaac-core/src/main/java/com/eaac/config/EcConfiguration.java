package com.eaac.config;

import com.eaac.container.Container;
import com.eaac.container.ContainerFactory;
import com.eaac.container.SpiContainerFactory;
import com.eaac.pipe.ChannelInboundHandler;
import com.eaac.pipe.ChannelOutboundHandler;
import com.eaac.pipe.DefaultPipeline;
import com.eaac.pipe.PipeLine;
import com.eaac.statement.HttpStatement;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

/**
 * The type Http data source.
 *
 * @author <a href="mailto:"
 * @date 2024 /09/17
 * @description ecConfiguration
 * @since 1.0
 */
public class EcConfiguration {
    private String[] scanPackage;
    private String[] supportType;

    private ContainerFactory containerFactory;

    private DefaultPipeline defaultPipeline;


    /**
     * Instantiates a new Ec configuration.
     *
     * @param scanPackage the scan package
     * @param supportType the support type
     */
    public EcConfiguration(String[] scanPackage, String[] supportType) {
        this.scanPackage = scanPackage;
        this.supportType = supportType;
        this.containerFactory = new SpiContainerFactory(this);
        this.defaultPipeline = new DefaultPipeline();
        //initialize
        initContainer(supportType);
    }

    private void initContainer(String[] supportType) {
        if (supportType !=null && supportType.length!=0){
            for (String type : supportType) {
                this.containerFactory.getContainer(type);
            }
        }
    }

    /**
     * Instantiates a new Ec configuration.
     *
     * @param supportType the support type
     */
    public EcConfiguration(String[] supportType) {
        this.scanPackage = new String[]{"com.eaac"};
        this.supportType = supportType;
        this.containerFactory = new SpiContainerFactory(this);
        this.defaultPipeline = new DefaultPipeline();
        //initialize
        initContainer(supportType);
    }

    /**
     * Get scan package string [ ].
     *
     * @return the string [ ]
     */
    public String[] getScanPackage() {
        return scanPackage;
    }

    /**
     * Sets scan package.
     *
     * @param scanPackage the scan package
     */
    public void setScanPackage(String[] scanPackage) {
        this.scanPackage = scanPackage;
    }

    /**
     * Gets statement.
     *
     * @param type  the type
     * @param appId the app id
     * @param uri   the uri
     * @return the statement
     */
    public HttpStatement getStatement(String type, String appId, String uri) {
        return containerFactory.getContainer(type).getStatement(appId, uri);
    }


    /**
     * Gets container.
     *
     * @param type    the type
     * @param args    the args
     * @param classes the classes
     * @return the container
     */
    public Container getContainer(String type, Object[] args, Class[] classes) {
        return containerFactory.getContainer(type, args, classes);
    }

    /**
     * Gets container.
     *
     * @param type the type
     * @param args the args
     * @return the container
     */
    public Container getContainer(String type, Object... args) {
        return containerFactory.getContainer(type, args);
    }


    /**
     * Add in pipe line.
     *
     * @param channelHandler the channel handler
     * @return the pipe line
     */
    public PipeLine addIn(ChannelInboundHandler channelHandler) {
        defaultPipeline.addIn(channelHandler);
        return defaultPipeline;
    }

    /**
     * Add out pipe line.
     *
     * @param channelHandler the channel handler
     * @return the pipe line
     */
    public PipeLine addOut(ChannelOutboundHandler channelHandler) {
        defaultPipeline.addOut(channelHandler);
        return defaultPipeline;
    }


    /**
     * Gets queue channel inbound handler.
     *
     * @return the queue channel inbound handler
     */
    public LinkedList<ChannelInboundHandler> getQueueChannelInboundHandler() {
        return defaultPipeline.getQueueChannelInboundHandler();
    }

    /**
     * Gets stack channel outbound handler.
     *
     * @return the stack channel outbound handler
     */
    public LinkedList<ChannelOutboundHandler> getStackChannelOutboundHandler() {
        return defaultPipeline.getStackChannelOutboundHandler();
    }

}
