package com.accountmaker.springboot.service.InboxLvService;

import com.accountmaker.springboot.model.webServices.InboxLv;
import com.accountmaker.springboot.repositories.InboxLvRepository;
import com.accountmaker.springboot.service.AbstractService;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("inboxlvService")
@Transactional
public class InboxLvServiceImpl extends AbstractService implements InboxLvService {

    @Autowired
    private InboxLvRepository inboxLvRepository;

    @Autowired
    ChromeDriver driver;


    public void createAccount(InboxLv account)  throws InterruptedException {

        //TODO Implement it!
    }

    public void login()  throws InterruptedException {
        driver.get("https://www.inbox.lv/");
        WebDriverWait wait = new WebDriverWait(driver, 30);

//        ExpectedCondition<Boolean> usernameFieldLoaded = input -> input.findElements(By.id("username")).size() > 0;
//        wait.until(usernameFieldLoaded);
        driver.findElementById("imapuser").sendKeys("abog944");
        driver.findElementById("pass").sendKeys("abog944@inbox.lv");
        driver.findElementById("btn_sign-in").click();

        System.out.println(driver.findElementById("headline__item_count-eml").getText());
    }
}
