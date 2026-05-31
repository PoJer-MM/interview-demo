package com.pojer.aspect;

import com.pojer.annotation.ReadOnly;
import com.pojer.annotation.WriteOnly;
import com.pojer.constant.DataSourceType;
import com.pojer.datasource.DataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 数据源切换切面
 */
@Aspect
@Component
@Order(-1)
public class DataSourceAspect {

    /**
     * 读方法
     */
    @Around("@annotation(readOnly)")
    public Object read(ProceedingJoinPoint pjp, ReadOnly readOnly) throws Throwable {
        try {
            DataSourceContextHolder.setDataSource(DataSourceType.SLAVE.getValue());
            System.out.println("USE SLAVE");
            return pjp.proceed();
        } finally {
            DataSourceContextHolder.clear();
        }
    }

    /**
     * 写方法
     */
    @Around("@annotation(writeOnly)")
    public Object write(ProceedingJoinPoint pjp, WriteOnly writeOnly) throws Throwable {
        try {
            DataSourceContextHolder.setDataSource(DataSourceType.MASTER.getValue());
            System.out.println("USE MASTER");
            return pjp.proceed();
        } finally {
            DataSourceContextHolder.clear();
        }
    }


}