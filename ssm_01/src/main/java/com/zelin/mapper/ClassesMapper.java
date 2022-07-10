package com.zelin.mapper;

import com.zelin.pojo.Classes;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface ClassesMapper extends Mapper<Classes> {
}