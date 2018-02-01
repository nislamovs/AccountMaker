package com.accountmaker.springboot.controller;

import com.accountmaker.springboot.service.RestClientService;
import com.accountmaker.springboot.model.User;
import com.accountmaker.springboot.service.MailService;
import com.accountmaker.springboot.service.dao.SlackPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/sys")
public class DiagnosticsController {

    private static final Logger LOG = LoggerFactory.getLogger(DiagnosticsController.class);
    private static final DateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Value("${application.version}")
    private String version;

    @Value("${application.deploymentdate}")
    private String deploymentDate;

    @Autowired
    Environment environment;
    @Autowired
    MailService mailService;
    @Autowired
    RestClientService restClientService;

    @GetMapping(value = "/healthcheck")
    public ResponseEntity<Map<String, String>> healthcheck() throws IOException {
        LOG.info("Healthcheck requested.");

        Map<String, String> params = new ManagedMap<>();
        params.put("Account creator", version);
        params.put("Deployment date", deploymentDate);
        params.put("Current date/time", String.valueOf(DATETIME_FORMAT.format(new Date())));
        params.put("Status", "OK");

        return new ResponseEntity<Map<String, String>>(params, HttpStatus.OK);
    }

    @GetMapping(value = "/alertmail")
    public ResponseEntity<Map<String, String>> alertmail() {

        try {
            LOG.info("Dropping exception ...");
            throw new RuntimeException("Testing alert service... check mail :)");
        } catch (RuntimeException e) {
            LOG.info("Catching exception ...");
            mailService.sendError(e);
        }

        LOG.info("Exception generated. Alert mail sent.");

        Map<String, String> params = new ManagedMap<>();
        params.put("Status", "Exception generated. Alert mail sent.");
        params.put("Time", String.valueOf(DATETIME_FORMAT.format(new Date())));

        return new ResponseEntity<Map<String, String>>(params, HttpStatus.OK);
    }

    @GetMapping(value = "/sendemail")
    public ResponseEntity<?> sendMail(
            @RequestParam(value = "keyword", required = false, defaultValue = "This is test message.") String keyword) {

        mailService.sendMail(keyword, environment.getProperty("alert.email.to"));
        return new ResponseEntity<>("{ok}", HttpStatus.OK);
    }

    @GetMapping(value = "/sendemailwithattachment")
    public ResponseEntity<?> sendMail(
            @RequestParam(value = "keyword", required = false, defaultValue = "This is test message.") String keyword,
            @RequestBody(required = false) String payload) {

        User user = new User();
        user.setKeyword(keyword);
        user.setEmail(environment.getProperty("alert.email.to"));

        List<String> list = new ArrayList<>();
        list.add("ID, Name, Surname, Age");
        list.add("1, John, Smith, 45");
        list.add("2, Jack, Anderson, 56");
        list.add("3, Fred, Daniels, 23");
        list.add("4, Dan, Collins, 88");

        mailService.sendAccountList(user, list);
        return new ResponseEntity<>("{ok}", HttpStatus.OK);
    }

    @GetMapping(value = "/testslack")
    public ResponseEntity<?> testSlack(
            @RequestParam(value = "keyword", required = false, defaultValue = "This is test message.") String keyword) {

        restClientService.post(environment.getProperty("slack.url"), new SlackPayload(keyword));
        return new ResponseEntity<>("{ok}", HttpStatus.OK);
    }
}

