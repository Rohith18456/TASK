package com.example;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class AppTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor js;


  @BeforeTest
  public void beforeTest() {


    // System.setProperty("wdm.cachePath", "D:\\webdriver_cache");
 WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();  

        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;

  }


@Test
public void loginTest() throws InterruptedException, IOException {
    driver.get("https://demoqa.com/login");

    WebElement username=driver.findElement(By.id("userName"));
    username.sendKeys("rohith");
    Thread.sleep(1000);


    WebElement password=driver.findElement(By.id("password"));
    password.sendKeys("Rohith@238");
    Thread.sleep(2000);


    WebElement login=driver.findElement(By.id("login"));
    login.click();
    Thread.sleep(3000);

}

@AfterTest
public void afterTest() {
  driver.quit();
}

}