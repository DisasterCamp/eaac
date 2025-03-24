package com.eaac.api;

import java.lang.annotation.*;

/**
 * The interface Statement mapper method.
 *
 * @author disaster
 * @since 1.0
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
