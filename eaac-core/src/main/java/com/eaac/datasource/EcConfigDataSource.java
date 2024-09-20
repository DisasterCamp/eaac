package com.eaac.datasource;

import com.eaac.config.EcConfiguration;
import com.eaac.statement.Statement;

/**
 * The type Ec config data source.
 *
 * @param <C> the type parameter
 */
public abstract class EcConfigDataSource<C extends Connection> implements DataSource<C> {
    /**
     * The Ec configuration.
     */
    protected EcConfiguration ecConfiguration;
    protected String type;

    public EcConfigDataSource(EcConfiguration ecConfiguration, String type) {
        this.ecConfiguration = ecConfiguration;
        this.type = type;
    }

}
