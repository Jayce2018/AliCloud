package com.jayce.alicloud.umsserver.dubbo.impl;

import com.alibaba.fastjson.JSONObject;
import com.jayce.alicloud.umsserver.common.base.BaseService;
import com.jayce.alicloud.umsserver.common.properties.EnvironmentProperties;
import com.jayce.alicloud.umsserver.dao.LibraryBookMapper;
import com.jayce.alicloud.umsserver.dubbo.DubboService;
import com.jayce.alicloud.umsserver.entity.LibraryBook;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@Service(version = "1.0.1",group = "sa")
@org.springframework.stereotype.Service
public class UmsDubboImpl extends BaseService<LibraryBookMapper, LibraryBook> implements DubboService {
    @Autowired
    private LibraryBookMapper libraryBookMapper;

    @Autowired
    private EnvironmentProperties environmentProperties;

    @Override
    public List<LibraryBook> umsDubbo() {
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        log.info(method+"版本信息：{}{}","1.0.1","sa");
        return libraryBookMapper.selectAll();
    }

    @Override
    public String umsDubboConfig() {
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        log.info(method+"版本信息：{}{}","1.0.1","sa");
        return JSONObject.toJSONString(environmentProperties);
    }
}
