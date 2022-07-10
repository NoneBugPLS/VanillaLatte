package com.zelin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "student")  这里一样所以就不用写了
@Component
public class Student implements Serializable {

    @Id   //代表学生表的🐖键
    private Integer sid;

    private String sname;

    private String sex;

    private Integer age;

    private String addr;

    private Integer cid;

    @Transient     //这代表下面的这变量你的数据库中没有是你新声明得    这transient使用的javax的
    private String cname;

}