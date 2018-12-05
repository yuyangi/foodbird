package com.sub.gen.strategy.factory;

import com.sub.gen.enums.InstanceMode;
import com.sub.gen.enums.MetaType;
import com.sub.gen.enums.ReferenceForm;
import com.sub.gen.enums.ReferenceType;
import com.sub.gen.codes.StrategySelective;
import com.sub.gen.strategy.DefaultCodeGenerateStrategy;
import com.sub.gen.strategy.ICodeGenerateStrategy;
import com.sub.gen.strategy.form.DefaultFormStrategy;
import com.sub.gen.strategy.form.DefineFormStrategy;
import com.sub.gen.strategy.form.InvokeFormStrategy;
import com.sub.gen.strategy.form.VariableFormStrategy;
import com.sub.gen.strategy.instance.InstanceStrategy;
import com.sub.gen.strategy.instance.StaticStrategy;
import com.sub.gen.strategy.meta.*;

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
