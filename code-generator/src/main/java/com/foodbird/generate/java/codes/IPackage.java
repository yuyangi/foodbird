package com.foodbird.generate.java.codes;

import com.foodbird.generate.java.ICoder;

import java.util.List;

/**
 * Created by yuyang on 2016/11/26.
 */
public interface IPackage extends ICoder {

    List<String> getPackages();

    List<IClass> getClasses();

    String toString();

}
