package com.eaac.datasource;

import com.eaac.config.EcConfiguration;
import com.eaac.extension.ExtensionLoader;
import com.eaac.statement.HttpStatement;
import com.eaac.statement.Statement;
import org.apache.commons.lang3.StringUtils;


/**
 * The type Spi data source factory.
 */
public class SpiDataSourceFactory implements DataSourceFactory {
    private EcConfiguration ecConfiguration;

    /**
     * Instantiates a new Spi data source factory.
     *
     * @param ecConfiguration the ec configuration
     */
    public SpiDataSourceFactory(EcConfiguration ecConfiguration) {
        this.ecConfiguration = ecConfiguration;
    }

    @Override
    public DataSource getDataSource(String type) {
        return getDataSource(type, null);
    }

    @Override
    public DataSource getDataSource(String type, Object... args) {
        String dataSourceType = StringUtils.isEmpty(type) ? "http" : type;
        DataSource dataSource = ExtensionLoader
                .getExtensionLoader(DataSource.class)
                .getExtension(dataSourceType, args);
        return dataSource;
    }

    @Override
    public DataSource getDataSource(String type, Object[] args, Class[] classes) {
        String dataSourceType = StringUtils.isEmpty(type) ? "http" : type;
        DataSource dataSource = ExtensionLoader
                .getExtensionLoader(DataSource.class)
                .getExtension(dataSourceType, args, classes);
        return dataSource;
    }
}
