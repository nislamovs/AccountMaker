package com.accountmaker.springboot.service.DropboxService;

import com.accountmaker.springboot.model.webServices.Dropbox;

public interface DropboxService {

    void createAccount(Dropbox account) throws InterruptedException;
}

