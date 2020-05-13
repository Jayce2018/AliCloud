package com.jayce.alicloud.umsserver.dubbo.impl;

import com.jayce.alicloud.umsserver.dubbo.DubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

@Slf4j
@Service(version = "0512", group = "sa")
public class UmsDubboImpl0512sa extends UmsDubboImpl implements DubboService {
    @Override
    public String umsDubboConfig() {
        log.info("版本信息：{}{}","0512","sa");
        return super.umsDubboConfig();
    }
}
