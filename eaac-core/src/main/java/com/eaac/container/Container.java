package com.eaac.container;

import com.eaac.config.EcConfiguration;
import com.eaac.extension.SPI;
import com.eaac.statement.HttpStatement;

/**
 * The interface Container.
 */
@SPI
public interface Container {
    /**
     * Gets statement.
     *
     * @param appId the app id
     * @param uri   the uri
     * @return the statement
     */
    HttpStatement getStatement(String appId, String uri);

}
