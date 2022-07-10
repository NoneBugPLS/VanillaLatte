package com.zelin.mapper;

import com.zelin.pojo.Telvisit;
import com.zelin.pojo.TelvisitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TelvisitMapper {
    long countByExample(TelvisitExample example);

    int deleteByExample(TelvisitExample example);

    int deleteByPrimaryKey(Integer tvid);

    int insert(Telvisit record);

    int insertSelective(Telvisit record);

    List<Telvisit> selectByExample(TelvisitExample example);

    Telvisit selectByPrimaryKey(Integer tvid);

    int updateByExampleSelective(@Param("record") Telvisit record, @Param("example") TelvisitExample example);

    int updateByExample(@Param("record") Telvisit record, @Param("example") TelvisitExample example);

    int updateByPrimaryKeySelective(Telvisit record);

    int updateByPrimaryKey(Telvisit record);
}