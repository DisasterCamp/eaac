package com.eaac.util;

import com.eaac.statement.HttpStatement;

/**
 * The type Key util.
 *
 * @author <a href="mailto:"
 * @date 2024 /09/17
 * @description key util
 * @since 1.0
 */
public class KeyUtil {
    private static final String separator = "_";


    /**
     * generate connection key.
     *
     * @param httpStatement the http statement
     * @return the connection key
     */
    public static String generateConnectionKey(HttpStatement httpStatement) {
        return httpStatement.getAppId() + separator + httpStatement.getUri();
    }


    /**
     * Generate statement key string.
     *
     * @param httpStatement the http statement
     * @return the string
     */
    public static String generateStatementKey(HttpStatement httpStatement) {
        return httpStatement.getUri() + separator + httpStatement.getInvokerType();
    }

    /**
     * Generate statement key string.
     *
     * @param uri         the uri
     * @param invokerType the invoker type
     * @return the string
     */
    public static String generateStatementKey(String uri, String invokerType) {
        return uri + separator + invokerType;
    }
}
