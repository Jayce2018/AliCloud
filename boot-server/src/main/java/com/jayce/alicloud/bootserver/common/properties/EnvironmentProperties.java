package com.jayce.alicloud.bootserver.common.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Data
@Component
@RefreshScope
public class EnvironmentProperties {

    @Value("${boot.value.gender}")
    public String gender;

    @Value("${boot.value.name}")
    public String name;













}
