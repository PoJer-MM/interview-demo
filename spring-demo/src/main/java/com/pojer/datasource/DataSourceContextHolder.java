package com.pojer.datasource;

/**
 * 数据源上下文
 */
public class DataSourceContextHolder {
    /**
     * 当前线程数据源
     */
    private static final ThreadLocal<String> CONTEXT = new ThreadLocal<>();
    /**
     * 设置数据源
     */
    public static void setDataSource(String dataSource) {
        CONTEXT.set(dataSource);
    }

    /**
     * 获取数据源
     */
    public static String getDataSource() {
        return CONTEXT.get();
    }

    /**
     * 清理数据源
     */
    public static void clear() {
        CONTEXT.remove();
    }
}
