package com.project.config;

import org.aeonbits.owner.Config;
@Config.Sources(value = "file:${user.dir}/src/test/resources/config/config.properties")
public interface FrameworkConfig extends Config {
    String url();
    int timeout();
    String browser();
}
