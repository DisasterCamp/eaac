package com.eaac.container;

import com.eaac.extension.SPI;


/**
 * The interface Container factory.
 */
public interface ContainerFactory {
    /**
     * Gets container.
     *
     * @param type the type
     * @return the container
     */
    Container getContainer(String type);

    /**
     * Gets container.
     *
     * @param type the type
     * @param args the args
     * @return the container
     */
    Container getContainer(String type, Object... args);


    /**
     * Gets container.
     *
     * @param type    the type
     * @param args    the args
     * @param classes the classes
     * @return the container
     */
    Container getContainer(String type, Object[] args,Class[] classes);
}
