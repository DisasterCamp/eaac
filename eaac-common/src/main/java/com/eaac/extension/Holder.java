package com.eaac.extension;

/**
 * The type Holder.
 *
 * @author  <a href="mailto:"
 * @date 2024 /09/17
 * @description holder
 * @param <T> the type parameter
 */
public class Holder<T> {

    private volatile T value;

    /**
     * Get t.
     *
     * @return the t
     */
    public T get() {
        return value;
    }

    /**
     * Set.
     *
     * @param value the value
     */
    public void set(T value) {
        this.value = value;
    }
}
