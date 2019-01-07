package com.foodbird.generate.dynamic.cascade;

import com.foodbird.common.context.FBIContext;
import com.foodbird.generate.dynamic.FBSeries;

import java.util.List;

public interface FBSeriesLoader {

    List<FBSeries> load(FBIContext context);

    FBSeries load(String serviceId);

}
