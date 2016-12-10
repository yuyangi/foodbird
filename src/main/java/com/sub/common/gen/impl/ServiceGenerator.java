package com.sub.common.gen.impl;

import com.sub.common.gen.constants.IConstants;
import com.sub.common.gen.tools.NameUtils;

/**
 * Created by yy111026 on 2016/12/8.
 */
public class ServiceGenerator implements IConstants {


    public String generate(EntityMeta entityMeta) {
        return generate(entityMeta.getPackages(), entityMeta.getEntityName());
    }

    public String generate(String packages, String entityName) {
        StringBuilder builder = new StringBuilder();

        builder.append("package " + packages + ";").append(LINE_SEPARATOR);
        builder.append("import java.util.List;").append(LINE_SEPARATOR);
        builder.append("import com.github.pagehelper.Page;").append(LINE_SEPARATOR);
        builder.append("import com.taobao.cun.auge.dal.domain.BusiWorkInstance;").append(LINE_SEPARATOR);
        builder.append("import com.taobao.cun.auge.platform.dto.BusiWorkInstanceCondition;").append(LINE_SEPARATOR);
        builder.append("public interface " + entityName + " Service {").append(LINE_SEPARATOR);
        builder.append("    Page<" + entityName + "> getList(" + entityName + "Condition condition);").append(LINE_SEPARATOR);
        builder.append("    " + entityName + "Dto get" + entityName + "ById(Long id);").append(LINE_SEPARATOR);
        builder.append("    Long add" + entityName + "(" + entityName + "" + getVarName(entityName) + ");").append(LINE_SEPARATOR);
        builder.append("    void delete" + entityName + "ById(Long id, String operator);").append(LINE_SEPARATOR);
        builder.append("    void update" + entityName + "(" + entityName + " " + getVarName(entityName) + ", String operator);").append(LINE_SEPARATOR);
        builder.append("}").append(LINE_SEPARATOR);

        return null;
    }

    private String getVarName(String entityName) {
        return NameUtils.getVarName(entityName);
    }

}
