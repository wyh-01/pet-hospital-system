package com.phs.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestCase {
    public WebDriver webDriver;

    // 测试打开百度网址
    @Test
    public void openBaidu() {
        Path p1 = Paths.get("src", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", p1.toAbsolutePath().toString());
        webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com");
    }

}

