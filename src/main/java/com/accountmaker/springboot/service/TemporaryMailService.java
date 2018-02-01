package com.accountmaker.springboot.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("tempMail")
public class TemporaryMailService extends AbstractService{

    @Autowired
    private ChromeDriver driver;

    public WebDriver getTemporaryMail(String emailAddress) {
        driver.get("http://tempinbox.com/");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.xpath("//*[@id=\"index-body\"]/div/form/input[1]")).sendKeys(emailAddress.split("@")[0]);
        driver.findElement(By.xpath("/html/body/div/div/div[4]/div/div/form/input[2]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[4]/div/div/form/span[2]/input")).click();

        return driver;
    }

    public List<String> getMailList(String email) {
        return convertList(getTemporaryMail(email)
                        .findElements(By.cssSelector("a[href*='messageId']")),
                       element->element.getAttribute("href"))
                       .stream().distinct().collect(Collectors.toList());
    }

    public List<String> getMail(String email, Integer emailIndex) {
        String path = getMailList("9oihbcAvkx8fDZs@tempinbox.com").get(emailIndex);

        driver.get(path);
        return new ArrayList<>(convertList(driver.findElements(By.id("eml-cke__body")), WebElement::getText));
    }

}
