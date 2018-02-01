package com.accountmaker.springboot.controller.webServices;

import com.accountmaker.springboot.model.webServices.Dropbox;
import com.accountmaker.springboot.service.DropboxService.DropboxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dropbox")
public class DropboxController {

    public static final Logger logger = LoggerFactory.getLogger(FacebookController.class);

    @Autowired
    DropboxService dropboxService;

    @GetMapping("/create/")
    public ResponseEntity<String> create() {
        System.out.println("Creating Dropbox account!");
        Dropbox dropboxAccount = new Dropbox(true);
        try {
            dropboxService.createAccount(dropboxAccount);
            System.out.println(dropboxAccount.toString());
        } catch (Exception e){
            System.out.println("Exception + "+ e);
        }

        return new ResponseEntity<String>("{OK}", HttpStatus.OK);
    }
}
