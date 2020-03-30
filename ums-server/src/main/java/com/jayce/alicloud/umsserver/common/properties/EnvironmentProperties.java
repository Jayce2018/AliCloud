package com.jayce.alicloud.umsserver.common.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Data
@Component
@RefreshScope
public class EnvironmentProperties {

    @Value("${ums.value.gender}")
    public String value;

    @Value("${ums.value.name}")
    public String name;













}
