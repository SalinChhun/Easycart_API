package com.kosign.easy_cart.util;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static boolean isNotNullOrEmpty(String ...strs) {
        for (String str : strs) {
            if (str == null || str.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
