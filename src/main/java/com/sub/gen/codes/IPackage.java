package com.sub.gen.codes;

import com.sub.gen.ICoder;

import java.util.List;

/**
 * Created by yuyang on 2016/11/26.
 */
public interface IPackage extends ICoder {

    List<String> getPackages();

    List<IClass> getClasses();

    String toString();

}
