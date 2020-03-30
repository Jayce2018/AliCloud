package com.jayce.alicloud.bootserver.controller;

import com.jayce.alicloud.bootserver.common.properties.EnvironmentProperties;
import com.jayce.alicloud.dubboapi.service.DubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/root")
public class BootController {
    @Autowired
    private EnvironmentProperties environmentProperties;

    @Reference(version = "1.0.1",group = "sa")
    private DubboService dubboService;

    @RequestMapping(value = "/value",method = {RequestMethod.GET})
    public String method() {
        return environmentProperties.getGender();
    }

    @RequestMapping(value = "/dubbo",method = {RequestMethod.GET})
    public String dubbo() {
        return dubboService.umsDubbo();
    }
}
