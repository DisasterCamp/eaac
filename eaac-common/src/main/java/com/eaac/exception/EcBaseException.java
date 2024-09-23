package com.eaac.exception;

import lombok.Data;

/**
 * The type Ec base exception.
 */
@Data
public class EcBaseException extends RuntimeException{
    /**
     * Instantiates a new Ec base exception.
     */
    public EcBaseException() {
    }

    /**
     * Instantiates a new Ec base exception.
     *
     * @param message the message
     */
    public EcBaseException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Ec base exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public EcBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Ec base exception.
     *
     * @param cause the cause
     */
    public EcBaseException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Ec base exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public EcBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
