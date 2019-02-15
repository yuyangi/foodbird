package com.foodbird.demo.service;

import com.foodbird.demo.domain.ActIdUser;
import com.foodbird.demo.domain.ActIdUserExample;
import com.foodbird.demo.mapper.ActIdUserMapper;
import com.foodbird.demo.mybatis.AccessType;
import com.foodbird.demo.mybatis.DataRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/31
 */
@Service
public class RouterTestService {

    @Autowired
    private ActIdUserMapper actIdUserMapper;

    @DataRouter
    //@DataRouter(AccessType.MASTER) 默认就是MASTER
    public List<ActIdUser> queryTest(String id) {
        ActIdUserExample example = new ActIdUserExample();
        example.createCriteria().andIdEqualTo(id);
        return actIdUserMapper.selectByExample(example);
    }

}
