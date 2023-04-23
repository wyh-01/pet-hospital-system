package com.phs.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoginTest {
    public WebDriver webDriver;

    @Test
    public void loginTest(){
//        管理员登录成功
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080");
        WebElement username = webDriver.findElement(By.id("login-username"));
        username.sendKeys("chris");
        WebElement password = webDriver.findElement(By.id("login-password"));
        password.sendKeys("123");
        WebElement buttonLogin = webDriver.findElement(By.id("button-login"));
        buttonLogin.click();
    }

    @Test
    public void loginTest2(){
//        管理员登录失败
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080");
        WebElement username = webDriver.findElement(By.id("login-username"));
        username.sendKeys("chris");
        WebElement password = webDriver.findElement(By.id("login-password"));
        password.sendKeys("1234");
        WebElement buttonLogin = webDriver.findElement(By.id("button-login"));
        buttonLogin.click();
    }

    @Test
    public void loginTest3(){
//        普通用户登录成功
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
    public void loginTest4(){
//        普通用户登录失败
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080");
        WebElement username = webDriver.findElement(By.id("login-username"));
        username.sendKeys("chen");
        WebElement password = webDriver.findElement(By.id("login-password"));
        password.sendKeys("1234");
        WebElement buttonLogin = webDriver.findElement(By.id("button-login"));
        buttonLogin.click();
    }

}

