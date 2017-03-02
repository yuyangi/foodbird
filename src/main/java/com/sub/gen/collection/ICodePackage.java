package com.sub.gen.collection;

import com.sub.gen.ICoder;

import java.util.List;

/**
 * Created by yy111026 on 2017/2/4.
 */
public interface ICodePackage extends ICoder {

    String getModule();

    String getLevel();

    List<ICoder> getCoders();

    void generate();

}
