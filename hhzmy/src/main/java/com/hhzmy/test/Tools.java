package com.hhzmy.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 作用：
 * 时间：2016/1124
 */
public class Tools {
    public static boolean isMoble(String str){
        Pattern pattern = Pattern.compile("1[0-9]{10}");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

}
