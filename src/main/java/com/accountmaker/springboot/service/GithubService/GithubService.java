package com.accountmaker.springboot.service.GithubService;

import com.accountmaker.springboot.model.webServices.Github;

public interface GithubService {

	void createAccount(Github account) throws InterruptedException;
}