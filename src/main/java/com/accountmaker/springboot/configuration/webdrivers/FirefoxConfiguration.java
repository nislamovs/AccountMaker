package com.accountmaker.springboot.configuration.webdrivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirefoxConfiguration {
/*
    @Value("${webdrivers.gecko.path}")
    private String path;

    @Bean
    public FirefoxDriver firefoxDriver() {
        System.setProperty("webdriver.gecko.driver", path);

//        String Xport = System.getProperty("lmportal.xvfb.id", ":1");
//        FirefoxBinary firefoxBinary = new FirefoxBinary();
//        firefoxBinary.setEnvironmentProperty("DISPLAY", Xport);
//
////        firefoxBinary.addCommandLineOptions("--headless");
//        FirefoxOptions options = new FirefoxOptions()
//                .setProfile(new FirefoxProfile());
//        options.setBinary(firefoxBinary);
//        options.setHeadless(true);

//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.setHeadless(true);
//
//
//        DesiredCapabilities caps = DesiredCapabilities.firefox();
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
////        firefoxOptions.addArguments("--headless");
//        FirefoxBinary firefoxBinary = new FirefoxBinary();
//        firefoxBinary.addCommandLineOptions("--headless");
//
//
//        caps.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);

        return new FirefoxDriver();
    }*/
}
