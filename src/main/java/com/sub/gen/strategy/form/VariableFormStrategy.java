package com.sub.gen.strategy.form;

import com.sub.gen.exception.UnsupportedFormException;
import com.sub.gen.meta.ICodeModel;
import com.sub.gen.strategy.ICodeGenerateStrategy;
import com.sub.gen.strategy.IGenMetaStrategy;
import com.sub.gen.strategy.factory.DefaultGenMetaStrategyFactory;
import com.sub.gen.strategy.factory.IGenMetaStrategyFactory;
import org.apache.log4j.Logger;

/**
 * Created by yy111026 on 2017/2/9.
 */
public class VariableFormStrategy implements ICodeGenerateStrategy {

    private Logger logger = Logger.getLogger(VariableFormStrategy.class);

    private IGenMetaStrategyFactory factory = DefaultGenMetaStrategyFactory.getInstance();

    @Override
    public String generate(ICodeModel model) {
        IGenMetaStrategy strategy = factory.create(model.getMetaType());
        if (strategy != null) {
            try {
                return strategy.variableForm(model, model.getCode());
            } catch (UnsupportedFormException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return null;
    }
}
