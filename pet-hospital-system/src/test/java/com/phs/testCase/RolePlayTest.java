package com.phs.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RolePlayTest {
    public WebDriver webDriver;
    @BeforeTest
    public void userLogin(){
//        普通用户登录
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080");
        WebElement username = webDriver.findElement(By.id("login-username"));
        username.sendKeys("chen");
        WebElement password = webDriver.findElement(By.id("login-password"));
        password.sendKeys("123");
        WebElement buttonLogin = webDriver.findElement(By.id("button-login"));
        buttonLogin.click();
    }

    @Test
    public void rolePlayTest(){
        webDriver.get("http://localhost:8080/rolePlay/doctor");
        WebElement enterRoomButton = webDriver.findElement(By.xpath("/html/body/div/div/ul/li[1]/a"));
        enterRoomButton.click();
    }
}
