package com.zelin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * ------------------------------
 * 功能：复杂属性对象
 * 作者：WF
 * 微信：hbxfwf13590332912
 * 创建时间：2021/11/9-10:28
 * ------------------------------
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionBeans {
    private String[] books;
    private List<Student> students;
    private Map<Integer,Student> map;
    private Properties properties;
}
