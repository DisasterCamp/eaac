package com.eaac.exec;

import com.eaac.statement.HttpStatement;

import java.util.Map;

/**
 * The interface Executor.
 */
public interface Executor {
    /**
     * Exec object.
     *
     * @param type   the type
     * @param appId  the app id
     * @param uri    the uri
     * @param params the params
     * @return the object
     * @throws Exception the exception
     */
    Object exec(String type,String appId,String uri, Object... params) throws Exception;
}
