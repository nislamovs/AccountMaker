package com.accountmaker.springboot.service.FacebookService;


import com.accountmaker.springboot.model.webServices.Dropbox;
import com.accountmaker.springboot.model.webServices.Facebook;

public interface FacebookService {

	void createAccount(Facebook account) throws InterruptedException;
}