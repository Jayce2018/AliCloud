package com.jayce.alicloud.umsserver.common.util;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 获取配置文件参数
 *
 * @author 111223/sunjie
 * @date 2020/3/11 20:35
 */

@Component
@Order(1)
public class EnvironmentUtil implements EnvironmentAware {

    private static Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        EnvironmentUtil.environment = environment;
    }

    /**
     * 获取环境变量中的配置属性
     */
    public String searchByKey(String key){
        return EnvironmentUtil.environment.getProperty(key);
    }
}