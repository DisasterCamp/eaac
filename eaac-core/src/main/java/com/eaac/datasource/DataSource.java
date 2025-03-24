package com.eaac.datasource;

import com.eaac.config.EcConfiguration;
import com.eaac.extension.SPI;
import com.eaac.statement.HttpStatement;
import com.eaac.statement.Statement;

/**
 * The interface Data source.
 *
 * @param <C> the type parameter
 * @author disaster
 * @since 1.0
 */
@SPI
public interface DataSource<C extends Connection> {
    /**
     * Gets connection.
     *
     * @param statement the statement
     * @return the connection
     */
    C getConnection(HttpStatement statement);


}
