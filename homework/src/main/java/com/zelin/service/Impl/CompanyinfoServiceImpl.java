package com.zelin.service.Impl;

import com.zelin.mapper.CompanyinfoMapper;
import com.zelin.mapper.TelvisitMapper;
import com.zelin.pojo.Companyinfo;
import com.zelin.service.CompanyinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名：
 * 作者：Lun
 * 功能：
 * 时间：2021/11/14 17:31
 */
@Service
public class CompanyinfoServiceImpl implements CompanyinfoService {

    @Autowired
    private CompanyinfoMapper companyinfoMapper;
    @Autowired
    private TelvisitMapper telvisitMapper;


    //1. 列表客户信息
    @Override
    public List<Companyinfo> findall() {
        //1. 得到所有客户信息
        List<Companyinfo> companyinfos = companyinfoMapper.selectByExample(null);
        //2. 返回
        return companyinfos;
    }
}
