package com.eaac.api;

import java.lang.annotation.*;

/**
 * The interface Statement mapper clazz.
 *
 * @author disaster
 * @since 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface StatementMapperClazz {
    /**
     * App ids string [ ].
     *
     * @return the string [ ]
     */
    String[] appIds();

    /**
     * Invoker type string.
     *
     * @return the string
     */
    String invokerType() default "http";
}
