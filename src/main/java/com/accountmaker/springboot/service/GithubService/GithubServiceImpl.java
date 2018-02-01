package com.accountmaker.springboot.service.GithubService;

import com.accountmaker.springboot.model.webServices.Github;
import com.accountmaker.springboot.repositories.GithubRepository;
import com.accountmaker.springboot.service.AbstractService;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("githubService")
@Transactional
public class GithubServiceImpl extends AbstractService implements GithubService {

	@Autowired
	private GithubRepository githubRepository;

	@Autowired
	ChromeDriver driver;

	public void createAccount(Github account) throws InterruptedException {
		account.setCurrentEmail(getTemporaryEmail());

		driver.get("https://github.com/join");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElementById("user_login").sendKeys(account.getUsername());

		//Page 1
		driver.findElement(By.id("user_email")).sendKeys(account.getCurrentEmail());
		driver.findElement(By.id("user_password")).sendKeys(account.getPassword());
		driver.findElement(By.id("signup_button")).click();

		//Page 2
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div/form/button")).click();

		//Page 3
		driver.get("https://github.com/dashboard");

		githubRepository.save(account);
		driver.quit();
	}

}
