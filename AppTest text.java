package com.example;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.nio.file.Files;
import java.time.Duration;
import java.io.IOException;
// import org.testng.Assert;
import org.testng.annotations.AfterTest;
public class AppTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor js;


  @BeforeTest
  public void beforeTest() {
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
    driver.get("https://demoqa.com/buttons");
    Actions actions = new Actions(driver);

    WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
    js.executeScript("arguments[0].scrollIntoView();", doubleClickButton);
    actions.doubleClick(doubleClickButton).perform();
    System.out.println(driver.findElement(By.id("doubleClickMessage")).getText());

    WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
    js.executeScript("arguments[0].scrollIntoView();", rightClickButton);
    actions.contextClick(rightClickButton).perform();
    System.out.println(driver.findElement(By.id("rightClickMessage")).getText());

    WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
    js.executeScript("arguments[0].scrollIntoView();", clickMeButton);
    actions.click(clickMeButton).perform();
    System.out.println(driver.findElement(By.id("dynamicClickMessage")).getText());

    driver.get("https://demoqa.com/upload-download");
    WebElement uploadButton = driver.findElement(By.id("uploadFile"));
    js.executeScript("arguments[0].scrollIntoView();", uploadButton);
    String filePath = new File("C:\\Users\\Subash Chandran K\\Pictures\\God of War Ragnarök\\ScreenShot-2025-5-27_10-57-33.png").getAbsolutePath();
    uploadButton.sendKeys(filePath);
    System.out.println("File uploaded");

    WebElement downloadButton = driver.findElement(By.id("downloadButton"));
    js.executeScript("arguments[0].scrollIntoView();", downloadButton);
    downloadButton.getAttribute("D:\\SOFTWARETESTING CLASS");
    downloadButton.click();
    System.out.println("Download initiated");
    Thread.sleep(5000);
    File downloadedFile = new File("D:\\SOFTWARETESTING CLASS\\sampleFile.jpeg");
    if (downloadedFile.exists()) {
        System.out.println("File downloaded successfully: " + downloadedFile.getAbsolutePath());
    } else {
        System.out.println("File download failed.");
    }

    Thread.sleep(2000);



    driver.get("https://demoqa.com/dynamic-properties");
    WebElement enableAfterButton = driver.findElement(By.id("enableAfter"));
    js.executeScript("arguments[0].scrollIntoView();", enableAfterButton);
    wait.until(ExpectedConditions.elementToBeClickable(enableAfterButton));
    enableAfterButton.click();

    System.out.println("After button clicked");
    WebElement colorChangeButton = driver.findElement(By.id("colorChange"));
    js.executeScript("arguments[0].scrollIntoView();", colorChangeButton);
    wait.until(ExpectedConditions.elementToBeClickable(colorChangeButton));
    colorChangeButton.click();
    System.out.println("Color change button clicked");
    WebElement visibleAfterButton = driver.findElement(By.id("visibleAfter"));
    js.executeScript("arguments[0].scrollIntoView();", visibleAfterButton);
    wait.until(ExpectedConditions.visibilityOf(visibleAfterButton));
    visibleAfterButton.click();
    System.out.println("Visible after button clicked");
    Thread.sleep(2000);
    


    
}

@AfterTest
public void afterTest() {
  driver.quit();
}

}