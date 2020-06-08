package com.jayce.alicloud.umsserver.dubbo.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

@Slf4j
@Service(version = "0512", group = "sa")
@org.springframework.stereotype.Service
public class UmsDubboImpl0512sa extends UmsDubboImpl {
    /*@Override
    public List<LibraryBook> umsDubbo() {
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        log.info(method+"版本信息：{}{}","0512","sa");
        return super.umsDubbo();
    }*/

    @Override
    public String umsDubboConfig() {
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        log.info(method+"版本信息：{}{}","0512","sa");
        return super.umsDubboConfig();
    }
}
