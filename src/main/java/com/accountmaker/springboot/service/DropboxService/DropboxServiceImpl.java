package com.accountmaker.springboot.service.DropboxService;

import com.accountmaker.springboot.model.webServices.Dropbox;
import com.accountmaker.springboot.repositories.DropboxRepository;
import com.accountmaker.springboot.service.AbstractService;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("dropboxService")
@Transactional
public class DropboxServiceImpl extends AbstractService implements DropboxService {

    @Autowired
    private DropboxRepository dropboxRepository;

    @Autowired
    ChromeDriver driver;

    public void createAccount(Dropbox account) throws InterruptedException {

        account.setCurrentEmail(getTemporaryEmail());

		driver.get("https://www.dropbox.com/register");
		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.findElement(By.xpath("/html/body/div[11]/div[1]/div[2]/div/div/div[2]/div[2]/form/div[1]/div[1]/div[1]/div[2]/input"))
              .sendKeys(account.getFirstname());
        driver.findElement(By.xpath("/html/body/div[11]/div[1]/div[2]/div/div/div[2]/div[2]/form/div[1]/div[1]/div[2]/div[2]/input"))
              .sendKeys(account.getLastname());
        driver.findElement(By.xpath("/html/body/div[11]/div[1]/div[2]/div/div/div[2]/div[2]/form/div[1]/div[2]/div[2]/input"))
                .sendKeys(account.getCurrentEmail());
        driver.findElement(By.xpath("/html/body/div[11]/div[1]/div[2]/div/div/div[2]/div[2]/form/div[1]/div[3]/div[2]/input"))
                .sendKeys(account.getPassword());
        driver.findElement(By.xpath("/html/body/div[11]/div[1]/div[2]/div/div/div[2]/div[2]/form/div[3]/input"))
                .click();
        driver.findElement(By.xpath("/html/body/div[11]/div[1]/div[2]/div/div/div[2]/div[2]/form/button[1]"))
                .click();

        Thread.sleep(3000);
        driver.get("https://www.dropbox.com/home");

        dropboxRepository.save(account);
//        driver.quit();
    }
}