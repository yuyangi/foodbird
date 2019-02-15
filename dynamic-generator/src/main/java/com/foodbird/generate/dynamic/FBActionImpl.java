package com.foodbird.generate.dynamic;

import com.foodbird.common.context.FBIContext;
import com.foodbird.generate.dynamic.enums.FBActionType;
import com.google.common.collect.Maps;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
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
    private Map<Class<?>, Integer> paramIndexCache = Maps.newHashMap();

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
        //Parameter[] parameters = method.getParameters();
        Object param = ctx.get(id());
        if (ArrayUtils.isNotEmpty(parameterTypes) && parameterTypes.length == 1) {
            if (parameterTypes[0].isAssignableFrom(param.getClass())) {
                return invoke(param);
            } else {
                boolean findAndInvoked = false;
                Object property;
                if (param.getClass().isArray()) {
                    property = findParamValueFromArray(param, parameterTypes[0]);
                    findAndInvoked = true;
                } else {
                    property = findParamValueFromProperty(param, parameterTypes[0]);
                    if (property != param) {
                        findAndInvoked = true;
                    }
                }

                if (!findAndInvoked) {
                    throw new IllegalArgumentException("No matched param for service[" + ArrayUtils.toString(serviceId()) + "].action[" + id() + "].");
                }
                return invoke(property);
            }
        } else if (ArrayUtils.isNotEmpty(parameterTypes)) {
            Object[] params = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> type = parameterTypes[i];
                Object property;
                if (param.getClass().isArray()) {
                    property = findParamValueFromArray(param, type);
                } else {
                    property = findParamValueFromProperty(param, type);
                    if (property == param) {
                        property = null;
                    }
                }
                params[i] = property;
            }
            return invoke(params);
        } else {
            return invoke();
        }
    }

    private Class<?> getDeclaredMethodParamType(Parameter parameter) {
        return parameter.getDeclaringExecutable().getDeclaringClass();
    }

    private Object findParamValueFromProperty(Object param, Class<?> parameterType) throws Exception {
        Object property = param;
        if (paramMapperCache.containsKey(parameterType)) {
            property = PropertyUtils.getProperty(param, paramMapperCache.get(parameterType));
        } else {
            Field[] declaredFields = param.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                if (parameterType.isAssignableFrom(field.getType())) {
                    property = PropertyUtils.getProperty(param, field.getName());
                    paramMapperCache.put(parameterType, field.getName());
                    return property;
                }
            }
        }
        return property;
    }

    private Object findParamValueFromArray(Object param, Class<?> parameterType) throws Exception {
        Object property = null;
        Object[] params = (Object[]) param;
        if (paramIndexCache.containsKey(parameterType)) {
            property = params[paramIndexCache.get(parameterType)];
        } else {
            for (int i = 0; i < params.length; i++) {
                Object p = params[i];
                if (parameterType.isAssignableFrom(p.getClass())) {
                    property = p;
                    paramIndexCache.put(parameterType, i);
                }
            }
        }
        return property;
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
