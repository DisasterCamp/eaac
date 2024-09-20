package com.eaac.container;

import com.eaac.config.EcConfiguration;
import com.eaac.datasource.DataSource;
import com.eaac.extension.ExtensionLoader;
import org.apache.commons.lang3.StringUtils;

/**
 * The type Spi container factory.
 */
public class SpiContainerFactory implements ContainerFactory {
    private EcConfiguration ecConfiguration;

    /**
     * Instantiates a new Spi container factory.
     *
     * @param ecConfiguration the ec configuration
     */
    public SpiContainerFactory(EcConfiguration ecConfiguration) {
        this.ecConfiguration = ecConfiguration;
    }

    @Override
    public Container getContainer(String type) {
        return getContainer(type, null);
    }

    @Override
    public Container getContainer(String type, Object... args) {
        String dataSourceType = StringUtils.isEmpty(type) ? "http" : type;
        Container container = ExtensionLoader
                .getExtensionLoader(Container.class)
                .getExtension(dataSourceType, args);
        return container;
    }

    @Override
    public Container getContainer(String type, Object[] args, Class[] classes) {
        String dataSourceType = StringUtils.isEmpty(type) ? "http" : type;
        Container container = ExtensionLoader
                .getExtensionLoader(Container.class)
                .getExtension(dataSourceType, args, classes);
        return container;
    }
}
