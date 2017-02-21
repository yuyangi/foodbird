package com.sub.gen.strategy.factory;

import com.sub.gen.enums.ReferenceForm;
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

    private static Map<ReferenceForm, IGenFormStrategy> cache = new ConcurrentHashMap<>();

    static {
        cache.put(ReferenceForm.Define, new DefineFormStrategy());
        cache.put(ReferenceForm.Invoke, new InvokeFormStrategy());
        cache.put(ReferenceForm.Variable, new VariableFormStrategy());
        cache.put(ReferenceForm.Param, new DefaultFormStrategy());
        cache.put(ReferenceForm.State, new DefaultFormStrategy());
    }

    private DefaultGenFormStrategyFactory() {

    }

    public static IGenFormStrategyFactory getInstance() {
        return instance;
    }

    @Override
    public IGenFormStrategy create(ReferenceForm referenceForm) {
        return cache.get(referenceForm);
    }
}
