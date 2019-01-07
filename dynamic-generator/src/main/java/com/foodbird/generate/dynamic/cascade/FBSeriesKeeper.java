package com.foodbird.generate.dynamic.cascade;

import com.foodbird.generate.dynamic.FBSeries;

import java.util.List;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/29
 */
public interface FBSeriesKeeper extends FBSeriesLoader {

    void save(FBSeries series);

    void saveAll(List<FBSeries> series);

}
