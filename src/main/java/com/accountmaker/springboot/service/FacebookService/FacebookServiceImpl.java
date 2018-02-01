package com.accountmaker.springboot.service.FacebookService;

import com.accountmaker.springboot.model.webServices.Facebook;
import com.accountmaker.springboot.repositories.FacebookRepository;
import com.accountmaker.springboot.service.AbstractService;
import com.accountmaker.springboot.service.TemporaryMailService;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("facebookService")
@Transactional
public class FacebookServiceImpl extends AbstractService implements FacebookService {

	@Autowired
	private FacebookRepository facebookRepository;

	@Autowired
	TemporaryMailService ts;

	@Autowired
	ChromeDriver driver;

	public void createAccount(Facebook account) {
//		ts.getMailList().stream().forEach(System.out::println);

		String email = RandomStringUtils.randomAlphabetic(15)+"@tempinbox.com";
		ts.getTemporaryMail(email);
		System.out.println(email);

		account.setCurrentEmail(email);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("firstname")).sendKeys(account.getFirstname());
		driver.findElement(By.name("lastname")).sendKeys(account.getLastname());
		driver.findElement(By.name("reg_email__")).sendKeys(account.getCurrentEmail());
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys(account.getCurrentEmail());
		driver.findElement(By.name("reg_passwd__")).sendKeys(account.getPassword());

		driver.findElement(By.id("day")).sendKeys(account.getBirthdayDay());
		driver.findElement(By.id("month")).sendKeys(account.getBirthdayMonth());
		driver.findElement(By.id("year")).sendKeys(account.getBirthdayYear());

		if(Facebook.Gender.FEMALE.equals(account.getGender())) {
			driver.findElements(By.name("sex")).get(0).click();    //woman
		} else {
			driver.findElements(By.name("sex")).get(1).click(); //man
		}

		driver.findElement(By.name("websubmit")).click(); //submit


		facebookRepository.save(account);



//		ts.getMail(email, 1).forEach(System.out::println);
//		ts.getMail("9oihbcAvkx8fDZs@tempinbox.com", 1).forEach(System.out::println);
	}


}
