package com.accountmaker.springboot.service.GmailService;


import com.accountmaker.springboot.model.webServices.Gmail;

public interface GmailService {

	void createAccount(Gmail account) throws InterruptedException;
}