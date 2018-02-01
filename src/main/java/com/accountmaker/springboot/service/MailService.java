package com.accountmaker.springboot.service;

import com.accountmaker.springboot.model.User;

import java.util.List;

public interface MailService {
    void sendError(Throwable t);
    void sendMail(String msg, String email);
    void sendAccountList(User user, List<String> generatedAccounts);

//    void sendActivationMail(User user);
//    void sendNewPasswordMail(User user, String passwd);
}