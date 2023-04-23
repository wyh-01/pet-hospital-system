package com.phs.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ManegeSystemTest {
    public WebDriver webDriver;

    @Test
    public void addDiseaseTest(){
//        病种管理添加成功
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/addDisease");
        WebElement kind = webDriver.findElement(By.xpath("/html/body/div/form/div[1]/div/select/option[2]"));
        kind.click();
        WebElement name = webDriver.findElement(By.id("name"));
        name.sendKeys("selenium测试");
        WebElement description = webDriver.findElement(By.id("description"));
        description.sendKeys("描述信息");
        WebElement buttonLogin = webDriver.findElement(By.xpath("/html/body/div/div[3]/div/button"));
        buttonLogin.click();
    }
    @Test
    public void modifyDiseaseTest(){
//        更改病种类型为内科病例   
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/diseaseManage");
        WebElement kind = webDriver.findElement(By.xpath("/html/body/div/section/div/nav/ul/li[2]/a/span"));
        kind.click();
        WebElement modifyButton = webDriver.findElement(By.xpath("/html/body/div/section/div/div/section[2]/div/div[2]/div[3]/button[1]"));
        modifyButton.click();
        WebElement newkind = webDriver.findElement(By.xpath("/html/body/div/form/div[1]/div/select/option[3]"));
        newkind.click();
        WebElement saveButton = webDriver.findElement(By.xpath("/html/body/div/div[3]/div/button"));
        saveButton.click();
    }

    @Test
    public void deleteDiseaseTest(){
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/diseaseManage");
        WebElement kind = webDriver.findElement(By.xpath("/html/body/div/section/div/nav/ul/li[2]/a/span"));
        kind.click();
        WebElement deleteButton = webDriver.findElement(By.xpath("/html/body/div/section/div/div/section[2]/div/div[2]/div[3]/button[2]"));
        deleteButton.click();
    }
}
