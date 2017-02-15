package com.sub.gen.strategy.factory;

import com.sub.gen.enums.CodeForm;
import com.sub.gen.strategy.IGenFormStrategy;
import com.sub.gen.strategy.form.DefaultFormStrategy;
import com.sub.gen.strategy.form.DefineFormStrategy;
import com.sub.gen.strategy.form.InvokeFormStrategy;
import com.sub.gen.strategy.form.VariableFormStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yy111026 on 2017/2/14.
 */
public class DefaultGenFormStrategyFactory implements IGenFormStrategyFactory {

    private static DefaultGenFormStrategyFactory instance = new DefaultGenFormStrategyFactory();

    private static Map<CodeForm, IGenFormStrategy> cache = new ConcurrentHashMap<>();

    static {
        cache.put(CodeForm.Define, new DefineFormStrategy());
        cache.put(CodeForm.Invoke, new InvokeFormStrategy());
        cache.put(CodeForm.Variable, new VariableFormStrategy());
        cache.put(CodeForm.Param, new DefaultFormStrategy());
        cache.put(CodeForm.State, new DefaultFormStrategy());
    }

    private DefaultGenFormStrategyFactory() {

    }

    public static IGenFormStrategyFactory getInstance() {
        return instance;
    }

    @Override
    public IGenFormStrategy create(CodeForm codeForm) {
        return cache.get(codeForm);
    }
}
