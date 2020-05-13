package com.jayce.alicloud.bootserver.controller;

import com.jayce.alicloud.bootserver.common.properties.EnvironmentProperties;
import com.jayce.alicloud.umsserver.dubbo.DubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/root")
public class BootController {
    @Autowired
    private EnvironmentProperties environmentProperties;

    @Reference(version = "1.0.1",group = "sa")
    private DubboService dubboService;

    @Reference(version = "0512", group = "sa")
    private DubboService dubboService0512sa;

    @Reference(version = "0512", group = "${ums.dubbo.group}")
    private DubboService dubboService0512su;

    public BootController() {
    }

    @RequestMapping(value = "/value",method = {RequestMethod.GET})
    public String method() {
        return environmentProperties.getGender();
    }

    @RequestMapping(value = "/dubbo",method = {RequestMethod.GET})
    public String dubbo() {
//        return dubboService.umsDubbo();
//        log.info(dubboService.umsDubboConfig());
//        log.info(dubboService0512sa.umsDubboConfig());
        log.info(dubboService0512su.umsDubboConfig());
        return "";
    }
}
