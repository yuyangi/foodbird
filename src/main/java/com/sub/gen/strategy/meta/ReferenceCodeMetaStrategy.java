package com.sub.gen.strategy.meta;

import com.sub.gen.enums.DataType;
import com.sub.gen.enums.MetaType;
import com.sub.gen.enums.ReferenceType;
import com.sub.gen.exception.UnsupportedFormException;
import com.sub.gen.meta.*;
import com.sub.gen.strategy.factory.DefaultCodeGenerateStrategyFactory;
import com.sub.gen.tools.CodeBuilder;
import com.sub.gen.tools.NameUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
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

    private Map<String, Integer> duplicateVarPool = new HashMap<>();

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
        Map<IType, IReference> dependResult = new HashMap<>();
        if(dependencies != null && dependencies.size() > 0) {
            dependencies.forEach(d -> {
                try {
                    code.append(this.stateForm(d));

                    String tempVarName = NameUtils.getVarName(d.getMethod().getReturnType().getType().getCode());
                    if (d.getMethod().getReturnType() == null ||  d.getMethod().getReturnType().getType().getCode().equals(DataType.VOID.name())) {
                        Integer varIncrease = duplicateVarPool.get(d.getMethod().getReturnType().getType().getVarName());
                        if (varIncrease == null) {
                            varIncrease = 1;
                        } else {
                            varIncrease ++;
                            tempVarName += varIncrease;
                        }
                        duplicateVarPool.put(d.getMethod().getReturnType().getType().getVarName(), varIncrease);
                    }
                    d.setReturnName(tempVarName);
                    dependResult.put(d.getMethod().getReturnType(), d);
                } catch (UnsupportedFormException e) {
                    logger.error(e.getMessage(), e);
                }
            });
        }
        String invokeSubject = reference.getReference().getVarName();
        IMethod method = reference.getMethod();
        IParameter[] params = parameters;
        if (reference.getReferenceType() == ReferenceType.STATIC_REFERENCE) {
            invokeSubject = reference.getReference().getCode();
        }
        if (method.getReturnType() == null || method.getReturnType().getType().getCode().equals(DataType.VOID)) {
            code.append(method.getReturnType().getType().getCode()).append(" ").append(method.getReturnType().getType().getVarName()).append(" = ");
        }

        List<String> paramList = new ArrayList<>();
        // 优先匹配引用依赖的参数
        if (!dependResult.isEmpty()) {
            IParameter[] methodParams = method.getParameters();
            for (IParameter mp : methodParams) {
                IReference returnRef = dependResult.get(mp.getType());
                if (returnRef != null) {
                    paramList.add(returnRef.getReturnName());
                } else {
                    paramList.add(NameUtils.getVarName(mp.getType().getType().getCode()));
                }
            }
        }

        // 无传入参数使用默认参数
        if (params == null) {
            params = method.getParameters();
        }
        if (params != null) {
            for (IParameter param : params) {
                paramList.add(param.getCode());
            }
        }
        code.append(invokeSubject).append(".").append(method.getCode() + "(" + String.join(",", paramList) + ");");
        return code.toString();
    }

    @Override
    public String variableForm(ICodeModel model, String varName) throws UnsupportedFormException {
        throw new UnsupportedFormException();
    }
}
