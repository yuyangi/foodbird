package com.sub.gen.strategy.meta;

import com.sub.gen.enums.MetaType;
import com.sub.gen.exception.UnsupportedFormException;
import com.sub.gen.meta.ICodeModel;
import com.sub.gen.meta.IParameter;
import com.sub.gen.meta.IReference;
import com.sub.gen.meta.IType;
import com.sub.gen.strategy.factory.DefaultCodeGenerateStrategyFactory;
import com.sub.gen.strategy.form.InvokeFormStrategy;
import com.sub.gen.tools.CodeBuilder;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  yy111026
 * 2017/2/9.
 */
public class ReferenceCodeMetaStrategy extends AbstractGenMetaStrategy {

    private Logger logger = Logger.getLogger(ReferenceCodeMetaStrategy.class);

    private DefaultCodeGenerateStrategyFactory factory = DefaultCodeGenerateStrategyFactory.getInstance();

    public ReferenceCodeMetaStrategy() {
        super();
    }

    @Override
    public String stateForm(ICodeModel model) throws UnsupportedFormException {
        return invokeForm(model);
    }

    @Override
    public String invokeForm(ICodeModel model, IParameter... parameters) throws UnsupportedFormException  {
        if (model.getMetaType() != MetaType.Reference) {
            throw new UnsupportedFormException();
        }

        IReference reference = (IReference)model;
        CodeBuilder code = new CodeBuilder();

        List<IReference> dependencies = reference.getDependencies();
        Map<IType, ICodeModel> dependResult = new HashMap<>();
        if(dependencies != null && dependencies.size() > 0) {
            dependencies.forEach(d -> {
                try {
                    code.append(this.stateForm(d));
                } catch (UnsupportedFormException e) {
                    logger.error(e.getMessage(), e);
                }
            });
        }
        return code.toString();
    }

    @Override
    public String variableForm(ICodeModel model, String varName) throws UnsupportedFormException {
        throw new UnsupportedFormException();
    }
}
