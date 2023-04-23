package com.phs.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ManegeSystemTest {
    public WebDriver webDriver;
    @BeforeTest
    public void adminLogin(){
//      管理员登录
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
    public void addDiseaseTest(){
//        病种管理添加成功
        webDriver.get("http://localhost:8080/diseaseManage");
        WebElement addButton = webDriver.findElement((By.xpath("/html/body/div/div/button")));
        addButton.click();
        WebElement kind = webDriver.findElement(By.xpath("/html/body/div/form/div[1]/div/select/option[2]"));
        kind.click();
        WebElement name = webDriver.findElement(By.id("name"));
        name.sendKeys("selenium测试");
        WebElement description = webDriver.findElement(By.id("description"));
        description.sendKeys("描述信息");
        WebElement saveButton = webDriver.findElement(By.xpath("//*[@id=\"form-disease-add\"]/div[7]/div/button"));
        saveButton.click();
    }
    @Test
    public void modifyDiseaseTest(){
//        更改病种类型为内科病例
        webDriver.get("http://localhost:8080/diseaseManage");
        WebElement kind = webDriver.findElement(By.xpath("/html/body/div/section/div/nav/ul/li[2]/a/span"));
        kind.click();
        WebElement modifyButton = webDriver.findElement(By.xpath("/html/body/div/section/div/div/section[2]/div/div[2]/div[3]/button[1]"));
        modifyButton.click();
        WebElement newkind = webDriver.findElement(By.xpath("/html/body/div/form/div[1]/div/select/option[3]"));
        newkind.click();
        WebElement name = webDriver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("selenium改名");
        WebElement description = webDriver.findElement(By.id("description"));
        description.clear();
        description.sendKeys("测试：更改描述信息");
        WebElement saveButton = webDriver.findElement(By.xpath("//*[@id=\"form-disease-add\"]/div[7]/div/button"));
        saveButton.click();
    }

    @Test
    public void deleteDiseaseTest(){
        webDriver.get("http://localhost:8080/diseaseManage");
        WebElement kind = webDriver.findElement(By.xpath("/html/body/div/section/div/nav/ul/li[3]/a/span"));
        kind.click();
        WebElement deleteButton = webDriver.findElement(By.xpath("//*[@id=\"section-shape-3\"]/div/div[3]/div[3]/button[2]"));
        deleteButton.click();
    }

    @Test
    public void addCaseTest(){
//        增加口炎病例，名称为selenium测试病例
        webDriver.get("http://localhost:8080/caseManageChoose");
        WebElement addButton = webDriver.findElement((By.xpath("/html/body/div/div/button")));
        addButton.click();
        WebElement diseaseKind = webDriver.findElement(By.xpath("//*[@id=\"disease\"]/option[2]"));
        diseaseKind.click();
        WebElement name = webDriver.findElement(By.id("name"));
        name.sendKeys("selenium测试病例");
        WebElement description = webDriver.findElement(By.id("description"));
        description.sendKeys("描述信息");
        WebElement saveButton = webDriver.findElement(By.xpath("/html/body/div/div/div/button"));
        saveButton.click();
    }
    @Test
    public void modifyCaseTest(){
//        更改病例的病种分类为犬瘟热，更改名称和描述
        webDriver.get("http://localhost:8080/caseManageChoose");
        WebElement section = webDriver.findElement(By.xpath("/html/body/div/section/div/nav/ul/li[3]/a/span"));
        section.click();
        WebElement diseaseKind = webDriver.findElement(By.xpath("/html/body/div/section/div/div/section[3]/div/div[1]"));
        diseaseKind.click();
        WebElement modifyButton = webDriver.findElement(By.xpath("/html/body/div/div/ul/li/div[2]/button[1]"));
        modifyButton.click();
        WebElement newDiseasekind = webDriver.findElement(By.xpath("//*[@id=\"disease\"]/option[1]"));
        newDiseasekind.click();
        WebElement name = webDriver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("selenium测试病例改名");
        WebElement description = webDriver.findElement(By.id("description"));
        description.clear();
        description.sendKeys("测试：更改病例描述信息");
        WebElement saveButton = webDriver.findElement(By.xpath("//*[@id=\"form-case-update\"]/div[8]/div/button"));
        saveButton.click();
    }

    @Test
    public void deleteCaseTest(){
//        删除测试病例
        webDriver.get("http://localhost:8080/caseManageChoose");
        WebElement diseaseKind = webDriver.findElement(By.xpath("//*[@id=\"diseaseName\"]/p"));
        diseaseKind.click();
        WebElement deleteButton = webDriver.findElement(By.xpath("/html/body/div/div/ul/li[1]/div[2]/button[2]"));
        deleteButton.click();
    }
}
