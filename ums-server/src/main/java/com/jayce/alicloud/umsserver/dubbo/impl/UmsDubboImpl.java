package com.jayce.alicloud.umsserver.dubbo.impl;

import com.alibaba.fastjson.JSONObject;
import com.jayce.alicloud.dubboapi.service.DubboService;
import com.jayce.alicloud.umsserver.dao.LibraryBookMapper;
import com.jayce.alicloud.umsserver.entity.LibraryBook;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@Service(version = "1.0.1",group = "sa")
public class UmsDubboImpl implements DubboService {
    @Autowired
    private LibraryBookMapper libraryBookMapper;

    @Override
    public String umsDubbo() {
        List<LibraryBook> libraryBooks = libraryBookMapper.selectAll();
        log.info("umsDubbo调用"+"dubbo");
        return JSONObject.toJSONString(libraryBooks);
    }
}
