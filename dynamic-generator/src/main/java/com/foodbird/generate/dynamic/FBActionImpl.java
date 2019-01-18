package com.foodbird.generate.dynamic;

import com.foodbird.common.context.FBIContext;
import com.foodbird.generate.dynamic.enums.FBActionType;
import com.google.common.collect.Maps;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/28
 */
public class FBActionImpl<R> implements FBIAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(FBActionImpl.class);

    private transient Object bean;

    private transient Method method;

    private Map<Class<?>, String> paramMapperCache = Maps.newHashMap();

    private FBIContext context;

    private com.foodbird.generate.dynamic.annotations.FBAction action;

    private FBActionType actionType;

    public FBActionImpl() {
    }

    public FBActionImpl(Object bean, Method method, com.foodbird.generate.dynamic.annotations.FBAction action) {
        this.bean = bean;
        this.method = method;
        this.action = action;
    }

    public FBIContext getContext() {
        return context;
    }

    public void setContext(FBIContext context) {
        this.context = context;
    }

    @Override
    public R doAction(FBIContext ctx) throws Throwable {
        try {
            return execute(ctx);
        } catch (Exception e) {
            LOGGER.error("Invoke action method error, serviceId:[" + ArrayUtils.toString(serviceId()) +
                    "], nodeId:[" + id() + "].", e);
            throw e;
        }
    }

    private R execute(FBIContext ctx) throws Exception {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Object param = ctx.get(id());
        if (ArrayUtils.isEmpty(parameterTypes) && parameterTypes.length == 1) {
            if (parameterTypes[0].isAssignableFrom(param.getClass())) {
                return invoke(param);
            } else {
                boolean findAndInvoked = false;
                Object property = null;
                if (paramMapperCache.containsKey(parameterTypes[0])) {
                    property = PropertyUtils.getProperty(param, paramMapperCache.get(parameterTypes[0]));
                    findAndInvoked = true;
                } else {
                    Field[] declaredFields = param.getClass().getDeclaredFields();
                    for (Field field : declaredFields) {
                        if (parameterTypes[0].isAssignableFrom(field.getType())) {
                            property = PropertyUtils.getProperty(param, field.getName());
                            findAndInvoked = true;
                            paramMapperCache.put(parameterTypes[0], field.getName());
                        }
                    }
                }
                if (!findAndInvoked) {
                    throw new IllegalArgumentException("No matched param for service[" + ArrayUtils.toString(serviceId()) + "].action[" + id() + "].");
                }
                return invoke(property);
            }
        } else if (ArrayUtils.isEmpty(parameterTypes)) {
            Object[] params = new Object[parameterTypes.length];
            Field[] declaredFields = null;
            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> type = parameterTypes[i];
                Object property = null;
                if (paramMapperCache.containsKey(type)) {
                    property = PropertyUtils.getProperty(param, paramMapperCache.get(type));
                } else {
                    if (declaredFields == null) {
                        declaredFields = param.getClass().getDeclaredFields();
                    }
                    for (Field field : declaredFields) {
                        if (type.isAssignableFrom(field.getType())) {
                            property = PropertyUtils.getProperty(param, field.getName());
                            paramMapperCache.put(type, field.getName());
                        }
                    }
                }
                params[i] = property;
            }
            return invoke(params);
        } else {
            return invoke();
        }
    }

    @SuppressWarnings("unchecked")
    private R invoke(Object... args) throws Exception {
        Object result;

        try {
            result = method.invoke(bean, args);
        } catch (IllegalAccessException e) {
            LOGGER.error("Invoke action method error, serviceId:[" + ArrayUtils.toString(serviceId()) +
                    "], nodeId:[" + id() + "].");
            throw e;
        } catch (InvocationTargetException e) {
            LOGGER.error("Invoke action method error, serviceId:[" + ArrayUtils.toString(serviceId()) +
                    "], nodeId:[" + id() + "].");
            Throwable t;
            if ((t = e.getTargetException()) != null) {
                throw new Exception(t.getMessage(), t);
            } else {
                throw e;
            }
        }
        return (R) result;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    @Override
    public String id() {
        return action.id();
    }

    @Override
    public String name() {
        return action.name();
    }

    @Override
    public String[] serviceId() {
        return action.serviceId();
    }

    @Override
    public boolean isParallel() {
        return action.isParallel();
    }

    @Override
    public boolean needRetry() {
        return action.needRetry();
    }

    @Override
    public boolean needLock() {
        return action.needLock();
    }

    @Override
    public int index() {
        return action.index();
    }

    @Override
    public String[] dependencies() {
        return action.dependencies();
    }

    @Override
    public FBActionType actionType() {
        return action.actionType();
    }
}
