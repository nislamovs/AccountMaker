package com.accountmaker.springboot.controller.webServices;

import com.accountmaker.springboot.model.webServices.Gmail;
import com.accountmaker.springboot.service.GmailService.GmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gmail")
public class GmailController {

	public static final Logger logger = LoggerFactory.getLogger(GmailController.class);

	@Autowired
	GmailService gmailService;

	@GetMapping("/create/")
	public ResponseEntity<String> create() {
		System.out.println("Creating Gmail account!");
		Gmail gmailAccount = new Gmail(true);
		try {
			gmailService.createAccount(gmailAccount);
			System.out.println(gmailAccount.toString());
		} catch (Exception e){
			System.out.println("Exception + "+ e);
		}

		return new ResponseEntity<String>("{OK}", HttpStatus.OK);
	}

}