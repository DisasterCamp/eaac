package com.eaac.exception;

import lombok.Data;

/**
 * The type Ec base exception.
 */
@Data
public class EcBaseException extends RuntimeException{
    public EcBaseException() {
    }

    public EcBaseException(String message) {
        super(message);
    }

    public EcBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public EcBaseException(Throwable cause) {
        super(cause);
    }

    public EcBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
