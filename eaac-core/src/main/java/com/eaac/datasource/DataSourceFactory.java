package com.eaac.datasource;

import com.eaac.config.EcConfiguration;
import com.eaac.statement.HttpStatement;
import com.eaac.statement.Statement;

/**
 * The interface Data source factory.
 */
public interface DataSourceFactory {
    /**
     * Gets data source.
     *
     * @param type the type
     * @return the data source
     */
    DataSource getDataSource(String type);

    /**
     * Gets data source.
     *
     * @param type the type
     * @param args the args
     * @return the data source
     */
    DataSource getDataSource(String type,Object... args);


    /**
     * Gets data source.
     *
     * @param type    the type
     * @param args    the args
     * @param classes the classes
     * @return the data source
     */
    DataSource getDataSource(String type, Object[] args, Class[] classes);
}
