package com.amber.dev.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SemFreud
 * @createTime 2019-04-27 10:36
 */
public class DateUtil {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getNowDate(){
        return simpleDateFormat.format(new Date());
    }
}
