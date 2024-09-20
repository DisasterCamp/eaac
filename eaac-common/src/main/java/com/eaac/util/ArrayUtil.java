package com.eaac.util;

/**
 * The type Array util.
 */
public class ArrayUtil {
    private static final String separator = ",";

    /**
     * Gets str by array.
     *
     * @param array the array
     * @return the str by array
     */
    public static String getStrByArray(String[] array) {
        if (array == null || array.length == 0) {
            return "";
        }
        StringBuilder parameterTypesStr = new StringBuilder();
        for (String parameterType : array) {
            parameterTypesStr.append(parameterType + separator);
        }
        return parameterTypesStr.substring(0, parameterTypesStr.length() - 1);
    }
}
