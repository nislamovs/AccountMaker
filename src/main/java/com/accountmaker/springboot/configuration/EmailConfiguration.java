package com.accountmaker.springboot.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import static org.apache.commons.lang3.StringUtils.split;

@Configuration
public class EmailConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(EmailConfiguration.class);

    @Value("${email.smtp.host}") private String host;
    @Value("${email.smtp.port}") private Integer port;
    @Value("${email.smtp.protocol}") private String protocol;
    @Value("${alert.email.username}") private String username;
    @Value("${alert.email.password}") private String password;
    @Value("${alert.email.from}") private String from;
    @Value("${alert.email.replyto}") private String replyTo;
    @Value("${alert.email.to}") private String to;
    @Value("${alert.email.subject.prefix}") private String subject;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(host);
        sender.setPort(port);
        sender.setProtocol(protocol);
        sender.setUsername(username);
        sender.setPassword(password);

        LOG.info("SMTP host and port: {}:{}", sender.getHost(), sender.getPort());
        return sender;
    }

    @Bean
    public SimpleMailMessage alertMessageTemplate() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setReplyTo(replyTo);
        message.setTo(to);
        message.setSubject(subject);

        return message;
    }
}