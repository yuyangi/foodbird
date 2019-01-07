package com.foodbird.generate.dynamic.cascade;

import com.foodbird.generate.dynamic.FBSeries;

import java.util.List;

/**
 * 逻辑序列解析方法：
 * 根据业务描述文字，解析成业务逻辑处理的动作序列
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/29
 */
public interface FBSeriesParser {

    FBSeries parse(String bizDesc);

    List<FBSeries> parse(List<String> bizDesc);

}
