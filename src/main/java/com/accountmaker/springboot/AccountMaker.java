package com.accountmaker.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.accountmaker.springboot.configuration.JpaConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;


@Import(JpaConfiguration.class)
@EnableScheduling
@SpringBootApplication(scanBasePackages={"com.accountmaker.springboot"})
public class AccountMaker {

	public static void main(String[] args) {
		SpringApplication.run(AccountMaker.class, args);
	}
}
