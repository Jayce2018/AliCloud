package com.jayce.alicloud.umsserver.controller;

import com.jayce.alicloud.umsserver.common.properties.EnvironmentProperties;
import com.jayce.alicloud.umsserver.dao.LibraryBookMapper;
import com.jayce.alicloud.umsserver.entity.LibraryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return environmentProperties.value;
    }

    @RequestMapping(value = "/dao")
    @ResponseBody
    public List<LibraryBook> dao() {
        return libraryBookMapper.selectTest();
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<LibraryBook> list() {
        return libraryBookMapper.selectAll();
    }
}