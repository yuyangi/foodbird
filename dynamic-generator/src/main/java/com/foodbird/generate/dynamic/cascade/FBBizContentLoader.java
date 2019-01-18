package com.foodbird.generate.dynamic.cascade;

import java.util.List;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/9
 */
public interface FBBizContentLoader {

    /**
     * 功能描述接口
     * @return 返回 功能名称——>功能描述
     */
    FBServiceContent serviceContent(String serviceName);

    /**
     * 所有业务功能描述
     * @return 所有功能描述信息
     */
    List<FBServiceContent> allServiceContents();

    /**
     * 所有业务功能描述(分页)
     * @return 所有功能描述信息
     */
    List<FBServiceContent> allServiceContentsByPage(int pageSize, int pageNum);

}
