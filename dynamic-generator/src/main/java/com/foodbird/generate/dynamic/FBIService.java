package com.foodbird.generate.dynamic;

import java.util.List;

public interface FBIService {

    List<FBIAction> getActions();

    Object process(Object... args);

}
