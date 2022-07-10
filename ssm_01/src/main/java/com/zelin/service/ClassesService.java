package com.zelin.service;

import com.zelin.pojo.Classes;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClassesService {
    List<Classes> findAll();
}
