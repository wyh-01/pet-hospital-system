package com.phs.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SignupTest {
    public WebDriver webDriver;


    @Test
    public void signupTest(){
//        用户注册成功
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080");
        WebElement buttonSignup = webDriver.findElement(By.id("button-signup"));
        buttonSignup.click();
        WebElement username = webDriver.findElement(By.id("login-username"));
        username.sendKeys("newUser");
        WebElement password = webDriver.findElement(By.id("login-password"));
        password.sendKeys("123456");
        WebElement buttonLogin = webDriver.findElement(By.id("button-login"));
        buttonLogin.click();
    }

    @Test
    public void signupTest2(){
//        用户名已存在，注册失败
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        webDriver = new ChromeDriver();
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


}

