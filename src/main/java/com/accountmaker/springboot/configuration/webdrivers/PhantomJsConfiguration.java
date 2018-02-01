package com.accountmaker.springboot.configuration.webdrivers;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhantomJsConfiguration {

    @Value("${webdrivers.phantomjs.enableJavascript}")
    private Boolean enableJavascript;

    @Value("${webdrivers.phantomjs.enableWebStorage}")
    private Boolean enableWebStorage;

    @Value("${webdrivers.phantomjs.port}")
    private Integer port;

    @Value("${webdrivers.phantomjs.path}")
    private String path;

    @Bean
    public PhantomJSDriver phantomJSDriver() {
        DesiredCapabilities caps = DesiredCapabilities.phantomjs();

        caps.setJavascriptEnabled(enableJavascript);
        caps.setCapability("webStorageEnabled", enableWebStorage);
        caps.setCapability("usingPort", port);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, path);
        return new PhantomJSDriver(caps);
    }
}
