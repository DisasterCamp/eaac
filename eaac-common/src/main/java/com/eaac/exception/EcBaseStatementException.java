package com.eaac.exception;

import lombok.Data;

@Data
public class EcBaseStatementException extends RuntimeException{
    private String appId;
    private String uri;
    private String type;

    public EcBaseStatementException(String appId, String uri, String type) {
        this.appId = appId;
        this.uri = uri;
        this.type = type;
    }

    public EcBaseStatementException(String message, String appId, String uri, String type) {
        super(message);
        this.appId = appId;
        this.uri = uri;
        this.type = type;
    }

    public EcBaseStatementException(String message, Throwable cause, String appId, String uri, String type) {
        super(message, cause);
        this.appId = appId;
        this.uri = uri;
        this.type = type;
    }

    public EcBaseStatementException(Throwable cause, String appId, String uri, String type) {
        super(cause);
        this.appId = appId;
        this.uri = uri;
        this.type = type;
    }

    public EcBaseStatementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String appId, String uri, String type) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.appId = appId;
        this.uri = uri;
        this.type = type;
    }
}
