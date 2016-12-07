package com.sub.common.gen.tools;

import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by yy111026 on 2016/12/7.
 */
public class CollectionUtils {

    public static <F,T> List<T> convert(List<F> list, Function<F, T> function) {
        Assert.checkNull(list);
        List<T> newList = new ArrayList<>(list.size());
        list.forEach(f -> newList.add(function.apply(f)));
        return newList;
    }

}