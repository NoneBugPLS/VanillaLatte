package com.zelin.service.Impl;

import com.zelin.mapper.TelvisitMapper;
import com.zelin.service.TelvisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类名：
 * 作者：Lun
 * 功能：
 * 时间：2021/11/14 17:31
 */
@Service
public class TelvisitServiceImpl implements TelvisitService {

    @Autowired
    private TelvisitMapper telvisitMapper;
}
