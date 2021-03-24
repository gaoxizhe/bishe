package com.example.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gao
 */
public class BaseContextHandler {
    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public BaseContextHandler() {
    }

    public static void set(String key, Object value) {
        Map<String, Object> map = (Map<String, Object>) threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }

        ((Map) map).put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = (Map<String, Object>) threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }

        return ((Map) map).get(key);
    }

    public static UserInfo getUser() {
        Object value = get("currentUser");
        return (UserInfo) value;
    }

    public static void setUser(UserInfo userInfo) {
        set("currentUser", userInfo);
    }

    private static String returnObjectValue(Object value) {
        return value == null ? null : value.toString();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
