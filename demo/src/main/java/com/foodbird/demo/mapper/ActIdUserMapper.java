package com.foodbird.demo.mapper;

import java.util.List;

import com.foodbird.demo.domain.ActIdUser;
import com.foodbird.demo.domain.ActIdUserExample;
import org.apache.ibatis.annotations.Param;

public interface ActIdUserMapper {
    long countByExample(ActIdUserExample example);

    int deleteByExample(ActIdUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(ActIdUser record);

    int insertSelective(ActIdUser record);

    List<ActIdUser> selectByExample(ActIdUserExample example);

    ActIdUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ActIdUser record, @Param("example") ActIdUserExample example);

    int updateByExample(@Param("record") ActIdUser record, @Param("example") ActIdUserExample example);

    int updateByPrimaryKeySelective(ActIdUser record);

    int updateByPrimaryKey(ActIdUser record);
}