package com.accountmaker.springboot.controller.webServices;

import com.accountmaker.springboot.model.webServices.Github;
import com.accountmaker.springboot.service.GithubService.GithubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/github")
public class GithubController {

	public static final Logger logger = LoggerFactory.getLogger(GithubController.class);

	@Autowired
	GithubService githubService;

	@GetMapping("/create/")
	public ResponseEntity<String> create() {
		System.out.println("Creating Github account!");
		Github githubAccount = new Github(true);
		try {
			githubService.createAccount(githubAccount);
			System.out.println(githubAccount.toString());
		} catch (Exception e){
			System.out.println("Exception + "+ e);
		}

		return new ResponseEntity<String>("{OK}", HttpStatus.OK);
	}
}