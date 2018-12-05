package com.foodbird.generate.java.strategy.form;

import com.foodbird.generate.java.codes.ICodeModel;
import com.foodbird.generate.java.exception.UnsupportedFormException;
import com.foodbird.generate.java.strategy.ICodeGenerateStrategy;
import com.foodbird.generate.java.strategy.IGenMetaStrategy;
import com.foodbird.generate.java.strategy.factory.DefaultGenMetaStrategyFactory;
import com.foodbird.generate.java.strategy.factory.IGenMetaStrategyFactory;
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
