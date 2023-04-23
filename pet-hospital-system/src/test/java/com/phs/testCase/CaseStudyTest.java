package com.phs.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CaseStudyTest {
    public WebDriver webDriver;

    @Test
    public void CaseStudyTest(){
//        页面访问成功
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/caseStudy/diseaseStudy/1");
    }
}
