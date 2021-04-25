package com.gaga.springbootdatasourceswitch.config;

/**
 * 保存数据源的key，切换并删除
 * @Author fuGaga
 * @Date 2021/4/22 15:57
 * @Version 1.0
 */
public class ThreadLocalDataSource {

    private static final ThreadLocal<String> dbKey = new ThreadLocal<String>();

    /**
     * 存入当前线程的数据类型
     * @Author fuGaga
     * @Date 2021/4/22 16:00
     * @return void
     **/
    public static void setDbKey(String key){
        dbKey.set(key);
    }

    /**
     * 获取当前线程的数据类型
     * @Author fuGaga
     * @Date 2021/4/22 16:00
     * @return java.lang.String
     **/
    public static String getDbKey(){
        return dbKey.get();
    }

    /**
     * 清除数据类型
     * @Author fuGaga
     * @Date 2021/4/22 16:01
     * @return void
     **/
    public static void removeKey(){
        dbKey.remove();
    }
}
