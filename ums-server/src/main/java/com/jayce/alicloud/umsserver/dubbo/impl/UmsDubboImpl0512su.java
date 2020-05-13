package com.jayce.alicloud.umsserver.dubbo.impl;

import com.jayce.alicloud.umsserver.dubbo.DubboService;
import com.jayce.alicloud.umsserver.entity.LibraryBook;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Slf4j
@Service(version = "0512", group = "su")
@org.springframework.stereotype.Service
public class UmsDubboImpl0512su extends UmsDubboImpl0512sa implements DubboService {
    @Override
    public List<LibraryBook> umsDubbo() {
        log.info("版本信息：{}{}","0512","su");
        return super.umsDubbo();
    }

    @Override
    public String umsDubboConfig() {
        log.info("版本信息：{}{}","0512","su");
        return super.umsDubboConfig();
    }
}
