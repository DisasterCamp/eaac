package com.eaac.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Reflection util.
 */
public class ReflectionUtil {
    private static String separator = ",";

    /**
     * Gets parameter types.
     *
     * @param method the method
     * @return the parameter types
     */
    public static String getParameterTypes(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length == 0) {
            return "";
        }
        StringBuilder parameterTypesStr = new StringBuilder();
        for (Class<?> parameterType : parameterTypes) {
            parameterTypesStr.append(parameterType.getCanonicalName() + separator);
        }
        return parameterTypesStr.substring(0, parameterTypesStr.length() - 1);
    }

    /**
     * Find parameter types clazz list.
     *
     * @param parameterTypes the parameter types
     * @return the list
     * @throws ClassNotFoundException the class not found exception
     */
    public static Class[] findParameterTypesClazz(String[] parameterTypes) throws ClassNotFoundException {
        if (Objects.isNull(parameterTypes)) return null;
        Class[] classArrayList = new Class[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            classArrayList[i] = Class.forName(parameterTypes[i]);
        }
        return classArrayList;
    }
}
