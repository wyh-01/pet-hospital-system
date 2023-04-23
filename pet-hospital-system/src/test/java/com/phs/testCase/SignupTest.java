package com.phs.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SignupTest {
    public WebDriver webDriver;
    @BeforeTest
    public void init(){
//      webDriver初始化
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        webDriver = new ChromeDriver();
    }

    @Test
    public void signupTest(){
//        用户注册成功
        webDriver.get("http://localhost:8080");
        WebElement buttonSignup = webDriver.findElement(By.id("button-signup"));
        buttonSignup.click();
        WebElement username = webDriver.findElement(By.id("login-username"));
        username.sendKeys("newUser");
        WebElement password = webDriver.findElement(By.id("login-password"));
        password.sendKeys("123456");
        WebElement buttonLogin = webDriver.findElement(By.id("button-login"));
        buttonLogin.click();

//        登录
        WebElement username2 = webDriver.findElement(By.id("login-username"));
        username2.sendKeys("newUser");
        WebElement password2 = webDriver.findElement(By.id("login-password"));
        password2.sendKeys("123456");
        WebElement buttonLogin2 = webDriver.findElement(By.id("button-login"));
        buttonLogin2.click();
    }

    @Test
    public void signupTest2(){
//        用户名已存在，注册失败
        webDriver.get("http://localhost:8080");
        WebElement buttonSignup = webDriver.findElement(By.id("button-signup"));
        buttonSignup.click();
        WebElement username = webDriver.findElement(By.id("login-username"));
        username.sendKeys("chris");
        WebElement password = webDriver.findElement(By.id("login-password"));
        password.sendKeys("1234");
        WebElement buttonLogin = webDriver.findElement(By.id("button-login"));
        buttonLogin.click();
    }
//    @AfterTest
//    public void deleteTestUser(){
//        目前没有实现用户管理功能，删除用户得在数据库里手动删除，所以此部分暂时为空。
//        执行完所有测试后，数据库会有所改变，增加了一个newUser
//    }



}

