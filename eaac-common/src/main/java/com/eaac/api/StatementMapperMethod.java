package com.eaac.api;

import java.lang.annotation.*;

/**
 * The interface Statement mapper method.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface StatementMapperMethod {

    /**
     * Uri string.
     *
     * @return the string
     */
    String uri();


}
