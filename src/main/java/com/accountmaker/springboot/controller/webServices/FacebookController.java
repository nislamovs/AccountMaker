package com.accountmaker.springboot.controller.webServices;

import com.accountmaker.springboot.model.webServices.Dropbox;
import com.accountmaker.springboot.model.webServices.Facebook;
import com.accountmaker.springboot.service.FacebookService.FacebookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facebook")
public class FacebookController {

	public static final Logger logger = LoggerFactory.getLogger(FacebookController.class);

	@Autowired
	FacebookService facebookService;

	@GetMapping("/create/")
	public ResponseEntity<String> create() {
		System.out.println("Launched Ok!");
		Facebook fbAccount = new Facebook(true);
		try {
			facebookService.createAccount(fbAccount);
			System.out.println(fbAccount.toString());
		} catch (Exception e){
			System.out.println("Exception + "+ e);
		}
		return new ResponseEntity<String>("{OK}", HttpStatus.OK);
	}
}