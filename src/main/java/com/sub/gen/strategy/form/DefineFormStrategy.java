package com.sub.gen.strategy.form;

import com.sub.gen.enums.MetaType;
import com.sub.gen.exception.UnsupportedFormException;
import com.sub.gen.meta.ICodeModel;
import com.sub.gen.strategy.IGenFormStrategy;
import com.sub.gen.strategy.IGenMetaStrategy;
import com.sub.gen.strategy.factory.DefaultGenMetaStrategyFactory;
import com.sub.gen.strategy.factory.IGenMetaStrategyFactory;

/**
 * @author yy111026 on 2017/2/9.
 */
public class DefineFormStrategy implements IGenFormStrategy {

    private IGenMetaStrategyFactory factory = DefaultGenMetaStrategyFactory.getInstance();

    @Override
    public String generate(ICodeModel model) throws UnsupportedFormException {
        IGenMetaStrategy strategy = factory.create(model.getMetaType());
        if (strategy != null) {
            try {
                return strategy.defineForm(model);
            } catch (UnsupportedFormException e) {
                throw e;
            }
        }
        return null;
    }
}
