package com.foodbird.generate.java.strategy.factory;

import com.foodbird.generate.java.codes.StrategySelective;
import com.foodbird.generate.java.enums.InstanceMode;
import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.enums.ReferenceForm;
import com.foodbird.generate.java.enums.ReferenceType;
import com.foodbird.generate.java.strategy.DefaultCodeGenerateStrategy;
import com.foodbird.generate.java.strategy.ICodeGenerateStrategy;
import com.foodbird.generate.java.strategy.form.DefaultFormStrategy;
import com.foodbird.generate.java.strategy.form.DefineFormStrategy;
import com.foodbird.generate.java.strategy.form.InvokeFormStrategy;
import com.foodbird.generate.java.strategy.form.VariableFormStrategy;
import com.foodbird.generate.java.strategy.instance.InstanceStrategy;
import com.foodbird.generate.java.strategy.instance.StaticStrategy;
import com.foodbird.generate.java.strategy.meta.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yy111026 on 2017/2/21.
 */
public class DefaultCodeGenerateStrategyFactory implements ICodeGenerateStrategyFactory {

    private static DefaultCodeGenerateStrategyFactory ourInstance = new DefaultCodeGenerateStrategyFactory();

    private static Map<String, Map<Object, ICodeGenerateStrategy>> cache = new HashMap<>();

    static {
        Map<Object, ICodeGenerateStrategy> metaMap = new HashMap<>();
        Map<Object, ICodeGenerateStrategy> formMap = new HashMap<>();
        Map<Object, ICodeGenerateStrategy> instMap = new HashMap<>();

        metaMap.put(MetaType.Attribute, new AttributeCodeMetaStrategy());
        metaMap.put(MetaType.Class, new ClassCodeMetaStrategy());
        metaMap.put(MetaType.Method, new MethodCodeMetaStrategy());
        metaMap.put(MetaType.Reference, new ReferenceCodeMetaStrategy());
        metaMap.put(MetaType.Type, new DefaultCodeMetaStrategy());
        metaMap.put(MetaType.Parameter, new DefaultCodeMetaStrategy());

        formMap.put(ReferenceForm.Define, new DefineFormStrategy());
        formMap.put(ReferenceForm.Invoke, new InvokeFormStrategy());
        formMap.put(ReferenceForm.Variable, new VariableFormStrategy());
        formMap.put(ReferenceForm.Param, new DefaultFormStrategy());
        formMap.put(ReferenceForm.State, new DefaultFormStrategy());

        instMap.put(ReferenceType.INSTANCE_REFERENCE, new InstanceStrategy());
        instMap.put(ReferenceType.STATIC_REFERENCE, new StaticStrategy());
        instMap.put(ReferenceType.WEAK_REFERENCE, new DefaultCodeGenerateStrategy());

        cache.put(MetaType.class.getName(), metaMap);
        cache.put(ReferenceForm.class.getName(), formMap);
        cache.put(InstanceMode.class.getName(), instMap);
    }

    public static DefaultCodeGenerateStrategyFactory getInstance() {
        return ourInstance;
    }

    private DefaultCodeGenerateStrategyFactory() {
    }

    @Override
    public ICodeGenerateStrategy create(StrategySelective selective) {
        return cache.get(selective.namespace()) != null ? cache.get(selective.namespace()).get(selective.selective()) : new DefaultCodeGenerateStrategy();
    }
}
