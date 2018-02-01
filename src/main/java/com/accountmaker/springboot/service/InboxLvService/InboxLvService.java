package com.accountmaker.springboot.service.InboxLvService;

import com.accountmaker.springboot.model.webServices.InboxLv;

public interface InboxLvService {

    void createAccount(InboxLv account) throws InterruptedException;
    void login() throws InterruptedException;
}
