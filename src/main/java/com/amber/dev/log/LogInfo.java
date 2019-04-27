package com.amber.dev.log;

import com.amber.dev.utils.DateUtil;

/**
 * @author SemFreud
 * @createTime 2019-04-27 10:28
 */
public class LogInfo {
    private Class clazz;
    public LogInfo(Class clazz){
        this.clazz = clazz;
    }

    public void info( String info){
        System.out.println(clazz.getName()+": "+ DateUtil.getNowDate()+" $"+info);
    }

    public static void main(String[] args) {
        LogInfo info =  new LogInfo(LogInfo.class);
        info.info("-------");
    }
}
