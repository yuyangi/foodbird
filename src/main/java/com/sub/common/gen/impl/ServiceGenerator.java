package com.sub.common.gen.impl;

import com.sub.common.gen.constants.IConstants;
import com.sub.common.gen.tools.FileUtils;
import com.sub.common.gen.tools.NameUtils;

/**
 * Created by yy111026 on 2016/12/8.
 */
public class ServiceGenerator implements IConstants {


    public String generate(String basePath, EntityMeta entityMeta) {
        return generate(entityMeta.getPackages(), entityMeta.getEntityName());
    }

    public String generate(String packages, String entityName) {
        StringBuilder builder = new StringBuilder();

        builder.append("}").append(LINE_SEPARATOR);

        return builder.toString();
    }

    public String generate(String basePath, String packages, String entityName) {
        String[] pkgs = packages.split(DOT);
        if (!basePath.endsWith("/")) {
            basePath += "/";
        }
        String path = basePath;
        for(int i = 0; i < pkgs.length; i++) {
            path += pkgs[i];
            FileUtils.createFolder(path);
        }
        String fileName = path + "/" + entityName;
        FileUtils.createFile(fileName);
        FileUtils.writeFile(fileName, generate(packages, entityName));
        return "Success";
    }

    private String getVarName(String entityName) {
        return NameUtils.getVarName(entityName);
    }

}
