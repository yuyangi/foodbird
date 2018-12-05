package com.foodbird.generate.java.strategy.form;

import com.foodbird.generate.java.codes.ICodeModel;
import com.foodbird.generate.java.exception.UnsupportedFormException;
import com.foodbird.generate.java.strategy.ICodeGenerateStrategy;
import com.foodbird.generate.java.strategy.IGenMetaStrategy;
import com.foodbird.generate.java.strategy.factory.DefaultGenMetaStrategyFactory;
import com.foodbird.generate.java.strategy.factory.IGenMetaStrategyFactory;
import org.apache.log4j.Logger;

/**
 * @author yy111026 on 2017/2/9.
 */
public class InvokeFormStrategy implements ICodeGenerateStrategy {

    private Logger logger = Logger.getLogger(InvokeFormStrategy.class);

    private IGenMetaStrategyFactory factory = DefaultGenMetaStrategyFactory.getInstance();

    @Override
    public String generate(ICodeModel model) {
        IGenMetaStrategy strategy = factory.create(model.getMetaType());
        if (strategy != null) {
            try {
                return strategy.invokeForm(model);
            } catch (UnsupportedFormException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return null;
    }

}
