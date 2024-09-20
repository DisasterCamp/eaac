package com.eaac.exception;

/**
 * The type Dup statement exception.
 */
public class DupStatementException extends EcBaseStatementException{

    /**
     * Instantiates a new Dup statement exception.
     *
     * @param appId the app id
     * @param uri   the uri
     * @param type  the type
     */
    public DupStatementException(String appId, String uri, String type) {
        super(appId, uri, type);
    }

    /**
     * Instantiates a new Dup statement exception.
     *
     * @param message the message
     * @param appId   the app id
     * @param uri     the uri
     * @param type    the type
     */
    public DupStatementException(String message, String appId, String uri, String type) {
        super(message, appId, uri, type);
    }

    /**
     * Instantiates a new Dup statement exception.
     *
     * @param message the message
     * @param cause   the cause
     * @param appId   the app id
     * @param uri     the uri
     * @param type    the type
     */
    public DupStatementException(String message, Throwable cause, String appId, String uri, String type) {
        super(message, cause, appId, uri, type);
    }

    /**
     * Instantiates a new Dup statement exception.
     *
     * @param cause the cause
     * @param appId the app id
     * @param uri   the uri
     * @param type  the type
     */
    public DupStatementException(Throwable cause, String appId, String uri, String type) {
        super(cause, appId, uri, type);
    }

    /**
     * Instantiates a new Dup statement exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     * @param appId              the app id
     * @param uri                the uri
     * @param type               the type
     */
    public DupStatementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String appId, String uri, String type) {
        super(message, cause, enableSuppression, writableStackTrace, appId, uri, type);
    }

    @Override
    public String toString() {
        return "DupStatementException{" +
                "appId='" + getAppId() + '\'' +
                ", uri='" + getUri() + '\'' +
                ", type='" + getType() + '\"' +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}
