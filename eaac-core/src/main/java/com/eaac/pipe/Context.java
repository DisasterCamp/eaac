package com.eaac.pipe;

import com.eaac.statement.HttpStatement;

/**
 * The interface Context.
 */
public interface Context {

    /**
     * Close.
     */
    void close();

    /**
     * Is close boolean.
     *
     * @return the boolean
     */
    boolean isClose();

    /**
     * Gets statement.
     *
     * @return the statement
     */
    HttpStatement getStatement();

}
