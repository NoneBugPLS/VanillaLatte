package com.zelin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 类名：
 * 作者：Lun
 * 功能：
 * 时间：2021/11/14 17:31
 */
@SpringBootApplication
@MapperScan("com.zelin.mapper")
public class MyBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBootApplication.class);
    }
}
