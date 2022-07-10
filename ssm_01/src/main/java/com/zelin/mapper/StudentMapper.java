package com.zelin.mapper;

import com.zelin.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

@Component
public interface StudentMapper extends Mapper<Student> {

}