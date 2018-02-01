package com.accountmaker.springboot.service.GmailService;

import com.accountmaker.springboot.model.webServices.Gmail;
import com.accountmaker.springboot.repositories.GmailRepository;
import com.accountmaker.springboot.service.AbstractService;
import io.spring.gradle.dependencymanagement.org.codehaus.plexus.util.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.LocalDateTime;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service("gmailService")
@Transactional
public class GmailServiceImpl extends AbstractService implements GmailService {

	@Autowired
	private GmailRepository gmailRepository;

	@Autowired
	ChromeDriver driver;

//	PhantomJSDriver driver;
//	@Autowired

//	@Autowired
//	FirefoxDriver driver;

    @Override
	public void createAccount(Gmail account) throws InterruptedException {

		driver.get("https://accounts.google.com/SignUp?");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1600,900));

		driver.findElement(By.id("FirstName")).sendKeys(account.getFirstname());
		driver.findElement(By.id("LastName")).sendKeys(account.getLastname());
		driver.findElement(By.id("GmailAddress")).sendKeys(account.getUsername());
		driver.findElement(By.id("Passwd")).sendKeys(account.getPassword());
		driver.findElement(By.id("PasswdAgain")).sendKeys(account.getPassword());
		driver.findElement(By.xpath("//div[@role='listbox']")).sendKeys(account.getBirthdayMonth());
		driver.findElement(By.name("BirthDay")).sendKeys(account.getBirthdayDay());
		driver.findElement(By.name("BirthYear")).sendKeys(account.getBirthdayYear());
		driver.findElement(By.xpath("//div[@aria-activedescendant=':d']")).sendKeys(account.getGender());
//		driver.findElement(By.xpath("//div[@id='phone-form-element']/table/tbody/tr/th/div")).click();
//		driver.findElement(By.xpath("//div[@id=':8s']//span[.='Canada']")).click();
		//Pomenjatj
		driver.findElement(By.id("RecoveryPhoneNumber")).clear();
		driver.findElement(By.id("RecoveryPhoneNumber")).sendKeys("+4368120428664");
		driver.findElement(By.name("RecoveryEmailAddress")).sendKeys("");
//		driver.findElement(By.xpath("//div[@id='CountryCode']/div[1]/div[2]")).click();
//		driver.findElement(By.xpath("//div[@id=':1p']//div[.='Canada']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("submitbutton")).click();
		driver.executeScript("scrollOnePage(); scrollOnePage();");
		driver.executeScript("submitForm();");

		Thread.sleep(2000);
		driver.findElement(By.id("next-button")).click();

		Thread.sleep(116000);
		driver.quit();

		gmailRepository.save(account);
	}


//	public void createAccount() {


	//		System.out.println("FirstName : " + driver.findElement(By.id("FirstName")).getAttribute("class"));
//		System.out.println("LastName : " + driver.findElement(By.id("LastName")).getAttribute("class"));
//		System.out.println("GmailAddress : " + driver.findElement(By.id("GmailAddress")).getAttribute("class"));
//		System.out.println("Passwd : " + driver.findElement(By.id("Passwd")).getAttribute("class"));
//		System.out.println("PasswdAgain : " + driver.findElement(By.id("PasswdAgain")).getAttribute("class"));
//		System.out.println("BirthMonth : " + driver.findElement(By.xpath("//div[@role='listbox']")).getAttribute("class"));
//		System.out.println("BirthDay : " + driver.findElement(By.id("BirthDay")).getAttribute("class"));
//		System.out.println("BirthYear : " + driver.findElement(By.id("BirthYear")).getAttribute("class"));
//		System.out.println("Gender : " + driver.findElement(By.xpath("//div[@aria-activedescendant=':d']")).getAttribute("class"));
//		System.out.println("RecoveryPhoneNumber : " + driver.findElement(By.id("RecoveryPhoneNumber")).getAttribute("class"));
//		System.out.println("RecoveryEmailAddress : " + driver.findElement(By.id("RecoveryEmailAddress")).getAttribute("class"));





//		System.out.println("### Creating new gmail account ###");
//
//
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://accounts.google.com/SignUp");
//
////RABOTAET////////////////////////////////////////////////////////////////////////////////////////////
////		for (int i = 0; i < 8; i++) {
////			driver.getKeyboard().pressKey(Keys.TAB);
////		}
////		for (int i = 0; i < 8; i++) {
////			driver.getKeyboard().pressKey(Keys.ARROW_DOWN);
////		}
////		driver.getKeyboard().pressKey(Keys.ENTER);
////		System.out.println(driver.findElement(By.id("BirthMonth")).getText());
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////		driver.executeScript("document.getElementById(':0').setAttribute('aria-posinset', '10')");
////		driver.executeScript("document.getElementById(':0').innerHTML ='October'");
////
////		System.out.println(driver.findElement(By.id(":0")).getAttribute("aria-posinset"));
////		System.out.println(driver.findElement(By.id("BirthMonth")).getText());
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
////		driver.findElement(By.id("FirstName")).click();
////		driver.findElement(By.id("FirstName")).clear();
////		driver.findElement(By.id("FirstName")).sendKeys(RandomStringUtils.randomAlphanumeric(15));
//		String sg = "document.getElementById('FirstName').innerHTML ='"+RandomStringUtils.randomAlphanumeric(15)+"'";
//		driver.executeScript(sg);
////		driver.findElement(By.id("LastName")).click();
////		driver.findElement(By.id("LastName")).clear();
////		driver.findElement(By.id("LastName")).sendKeys(RandomStringUtils.randomAlphanumeric(15));
////		driver.findElement(By.id("GmailAddress")).click();
////		driver.findElement(By.id("GmailAddress")).clear();
////		driver.findElement(By.id("GmailAddress")).sendKeys(RandomStringUtils.randomAlphanumeric(15));
//
////		System.out.println("Name : " + driver.findElementById("FirstName").getText());
//		System.out.println("Surname : " + driver.findElement(By.id("FirstName")).getText());
////		System.out.println("Gmail address : " + driver.findElement(By.id("GmailAddress")).getText() + "@gmail.com" );
//
////		String passwd = RandomStringUtils.randomAlphanumeric(15);
////		driver.findElement(By.id("Passwd")).click();
//////		driver.findElement(By.id("Passwd")).clear();
////		driver.findElement(By.id("Passwd")).sendKeys(passwd);
////		driver.findElement(By.id("PasswdAgain")).click();
//////		driver.findElement(By.id("PasswdAgain")).clear();
////		driver.findElement(By.id("PasswdAgain")).sendKeys(passwd);
////		System.out.println("Password : "+driver.findElementById("PasswdAgain").getText());
//
//		driver.executeScript("document.getElementById(':0').setAttribute('aria-posinset', '10')");
//		driver.executeScript("document.getElementById(':0').innerHTML ='October'");
//
//		System.out.println(driver.findElement(By.id(":0")).getAttribute("aria-posinset"));
//		System.out.println(driver.findElement(By.id("BirthMonth")).getText());
//
//		driver.findElement(By.id("BirthDay")).click();
//		driver.findElement(By.id("BirthDay")).clear();
//		driver.findElement(By.id("BirthDay")).sendKeys("12");
//		driver.findElement(By.id("BirthYear")).click();
//		driver.findElement(By.id("BirthYear")).clear();
//		driver.findElement(By.id("BirthYear")).sendKeys("1988");
//
//
//		driver.executeScript("document.getElementById(':d').setAttribute('aria-posinset', '2')");
//		driver.executeScript("document.getElementById(':d').innerHTML ='Male'");
//
//		System.out.println(driver.findElement(By.id(":d")).getAttribute("aria-posinset"));
//		System.out.println(driver.findElement(By.id("Gender")).getText());
//
//		driver.findElement(By.id("submitbutton")).click();
//		System.out.println("#1");
////		driver.findElement(By.id("header-text-div")).getText();
//		driver.findElement(By.id("tos-scroll-button")).click();
//		System.out.println("#2");
//		driver.findElement(By.id("tos-scroll-button")).click();
//		System.out.println("#3");
//		driver.findElement(By.id("tos-scroll-button")).click();
//		System.out.println("#4");
////		driver.findElement(By.id("tos-scroll-button")).click();
//		driver.findElement(By.id("iagreebutton")).click();
//		driver.findElement(By.tagName("b")).getText();
//
////		driver.quit();
//
////		System.out.println(driver.findElementByXPath("/html/body/div[1]/div[3]/div/h2").getText());
//
//	}


	private void takeScreenshot() {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			String fname =   LocalDateTime.now().toString()
					+ RandomStringUtils.randomAlphanumeric(5)
					+ ".jpg";

			FileUtils.copyFile(file, new File("src/main/resources/screenshots/"+fname));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
