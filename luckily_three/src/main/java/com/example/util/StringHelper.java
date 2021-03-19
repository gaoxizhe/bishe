package com.example.util;

/**
 * @author gao
 */
public class StringHelper {
    public StringHelper() {
    }

    public static String getObjectValue(Object obj) {
        return obj == null ? "" : obj.toString();
    }
}
