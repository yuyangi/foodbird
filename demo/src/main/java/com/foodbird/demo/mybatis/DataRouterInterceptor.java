package com.foodbird.demo.mybatis;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author yuyang48
 * @prject nile
 * @date 2019/1/21
 */
@Component
@Aspect
@Intercepts({@Signature(
        type = StatementHandler.class,
        method = "prepare",
        args = {Connection.class, Integer.class})})
public class DataRouterInterceptor implements Interceptor {

    public static final Logger logger = LoggerFactory.getLogger(DataRouterInterceptor.class);

    public static final String MASTER_TAG = "/*master*/";
    public static final String MASTER_TAG_START = "/*";
    public static final String MASTER_TAG_END = "*/";

    private Field sqlField = null;

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (threadLocal.get() != null) {
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            BoundSql boundSql = statementHandler.getBoundSql();
            String sql = boundSql.getSql();
            if (sqlField == null) {
                sqlField = BoundSql.class.getDeclaredField("sql");
                sqlField.setAccessible(true);
            }
            StringBuilder builder = new StringBuilder();
            sqlField.set(boundSql, builder
                    .append(MASTER_TAG_START)
                    .append(threadLocal.get())
                    .append(MASTER_TAG_END)
                    .append(sql)
                    .toString());
            logger.info("Route access to "+threadLocal.get()+";\nSQL:{}", boundSql.getSql());
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    @Pointcut("@annotation(com.foodbird.demo.mybatis.DataRouter)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object routeDataAccess(ProceedingJoinPoint pjp) throws Throwable {
        org.aspectj.lang.Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        DataRouter router = method.getAnnotation(DataRouter.class);
        threadLocal.set(router.value().name().toLowerCase());
        Object result = pjp.proceed(pjp.getArgs());
        threadLocal.remove();
        return result;
    }

}
