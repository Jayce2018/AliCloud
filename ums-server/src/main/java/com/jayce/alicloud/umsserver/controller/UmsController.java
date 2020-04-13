package com.jayce.alicloud.umsserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.jayce.alicloud.umsserver.common.properties.EnvironmentProperties;
import com.jayce.alicloud.umsserver.dao.LibraryBookMapper;
import com.jayce.alicloud.umsserver.entity.LibraryBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RefreshScope
@RequestMapping(value = "/ums")
public class UmsController {
    @Autowired
    private LibraryBookMapper libraryBookMapper;

    @Autowired
    private EnvironmentProperties environmentProperties;

    @RequestMapping(value = "/value")
    public String method() {
        log.info("value:"+ environmentProperties.value);
        return environmentProperties.value;
    }

    @RequestMapping(value = "/dao")
    @ResponseBody
    public List<LibraryBook> dao() {
        List<LibraryBook> libraryBooks = libraryBookMapper.selectTest();
        log.info("libraryBooks:"+ JSONObject.toJSONString(libraryBooks));
        return libraryBooks;
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<LibraryBook> list() {
        List<LibraryBook> libraryBooks = libraryBookMapper.selectAll();
        log.info("libraryBooks:"+ JSONObject.toJSONString(libraryBooks));
        return libraryBooks;
    }
}
