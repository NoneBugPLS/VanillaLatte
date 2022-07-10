package com.zelin.mapper;

import com.zelin.pojo.Companyinfo;
import com.zelin.pojo.CompanyinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyinfoMapper {
    long countByExample(CompanyinfoExample example);

    int deleteByExample(CompanyinfoExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Companyinfo record);

    int insertSelective(Companyinfo record);

    List<Companyinfo> selectByExample(CompanyinfoExample example);

    Companyinfo selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Companyinfo record, @Param("example") CompanyinfoExample example);

    int updateByExample(@Param("record") Companyinfo record, @Param("example") CompanyinfoExample example);

    int updateByPrimaryKeySelective(Companyinfo record);

    int updateByPrimaryKey(Companyinfo record);
}