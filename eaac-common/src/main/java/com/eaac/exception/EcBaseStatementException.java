package com.eaac.exception;

import lombok.Data;

/**
 * The type Ec base statement exception.
 */
@Data
public class EcBaseStatementException extends RuntimeException{
    private String appId;
    private String uri;
    private String type;

    /**
     * Instantiates a new Ec base statement exception.
     *
     * @param appId the app id
     * @param uri   the uri
     * @param type  the type
     */
    public EcBaseStatementException(String appId, String uri, String type) {
        this.appId = appId;
        this.uri = uri;
        this.type = type;
    }

    /**
     * Instantiates a new Ec base statement exception.
     *
     * @param message the message
     * @param appId   the app id
     * @param uri     the uri
     * @param type    the type
     */
    public EcBaseStatementException(String message, String appId, String uri, String type) {
        super(message);
        this.appId = appId;
        this.uri = uri;
        this.type = type;
    }

    /**
     * Instantiates a new Ec base statement exception.
     *
     * @param message the message
     * @param cause   the cause
     * @param appId   the app id
     * @param uri     the uri
     * @param type    the type
     */
    public EcBaseStatementException(String message, Throwable cause, String appId, String uri, String type) {
        super(message, cause);
        this.appId = appId;
        this.uri = uri;
        this.type = type;
    }

    /**
     * Instantiates a new Ec base statement exception.
     *
     * @param cause the cause
     * @param appId the app id
     * @param uri   the uri
     * @param type  the type
     */
    public EcBaseStatementException(Throwable cause, String appId, String uri, String type) {
        super(cause);
        this.appId = appId;
        this.uri = uri;
        this.type = type;
    }

    /**
     * Instantiates a new Ec base statement exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     * @param appId              the app id
     * @param uri                the uri
     * @param type               the type
     */
    public EcBaseStatementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String appId, String uri, String type) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.appId = appId;
        this.uri = uri;
        this.type = type;
    }
}
