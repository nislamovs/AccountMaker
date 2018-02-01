package com.accountmaker.springboot.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service("abstractService")
public class AbstractService {

    @Value("${temporaryMail.tenMinMail}")
    private String tenMinMailUrl;

    @Autowired
    private RestClientService restClientService;
    @Autowired
    Environment environment;

    public static <T, U> List<U> convertList(List<T> from, Function<T, U> func) {
        return from.stream().map(func).collect(Collectors.toList());
    }

    public String getTemporaryEmail() {
//        System.out.println(">>> " + environment.getProperty("temporaryMail.tenMinMail"));
//        System.out.println(restClientService.get(tenMinMailUrl).toString().stream().);
        return RandomStringUtils.randomAlphanumeric(10) + "@mail.com";
    }

    public String getFakeEmail() {
//        RestClientService rs = new RestClientService();


        https://www.crazymailing.com/

        return RandomStringUtils.randomAlphanumeric(10) + "@mail.com";
    }

}
