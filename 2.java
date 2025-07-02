package com.example;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
    System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
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
    driver.get("https://demoqa.com/automation-practice-form");

    WebElement firstName = driver.findElement(By.id("firstName"));
    js.executeScript("arguments[0].scrollIntoView(true);", firstName);
    firstName.sendKeys("S");
    System.out.println("Firast name entered");
    WebElement lastName = driver.findElement(By.id("lastName"));
    js.executeScript("arguments[0].scrollIntoView(true);", lastName);
    lastName.sendKeys("Rohith");
    System.out.println("Last name entered");

    WebElement email = driver.findElement(By.id("userEmail"));
    js.executeScript("arguments[0].scrollIntoView(true);", email);
    email.sendKeys("717822e238@kce.ac.in");
    System.out.println("Email entered");

    WebElement gender = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
    js.executeScript("arguments[0].scrollIntoView(true);", gender);
    gender.click();
    System.out.println("Gender selected");

    WebElement mobile = driver.findElement(By.id("userNumber"));
    js.executeScript("arguments[0].scrollIntoView(true);", mobile);
    mobile.sendKeys("8778447317");
    System.out.println("Mobile number entered");

    WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
    js.executeScript("arguments[0].scrollIntoView(true);", dateOfBirth);
    dateOfBirth.click();
    WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
    js.executeScript("arguments[0].scrollIntoView(true);", month);
    month.click();
    month.sendKeys("June");
    month.sendKeys(Keys.ENTER);
    System.out.println("Month selected");
    WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
    js.executeScript("arguments[0].scrollIntoView(true);", year);
    year.click();
    year.sendKeys("2005");
    year.sendKeys(Keys.ENTER);
    System.out.println("Year selected");
    WebElement day = driver.findElement(By.xpath("//div[@aria-label='Choose Saturday, June 18th, 2005']"));
    js.executeScript("arguments[0].scrollIntoView(true);", day);
    day.click();
    System.out.println("Day selected");

    WebElement subjects = driver.findElement(By.id("subjectsInput"));
    js.executeScript("arguments[0].scrollIntoView(true);", subjects);
    subjects.sendKeys("Software Testing");
    System.out.println("Subject selected");

    WebElement hobbies1 = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
    js.executeScript("arguments[0].scrollIntoView(true);", hobbies1);
    hobbies1.click();
    WebElement hobbies2 = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));
    js.executeScript("arguments[0].scrollIntoView(true);", hobbies2);
    hobbies2.click();
    System.out.println("Hobby selected");

    WebElement picture = driver.findElement(By.id("uploadPicture"));
    js.executeScript("arguments[0].scrollIntoView(true);", picture);
    File file = new File("C:\\Users\\Subash Chandran K\\Pictures\\God of War Ragnarök\\ScreenShot-2025-5-27_10-57-33.png");
    String absolutePath = file.getAbsolutePath();
    picture.sendKeys(absolutePath);
    System.out.println("Picture uploaded");

    WebElement address = driver.findElement(By.id("currentAddress"));
    js.executeScript("arguments[0].scrollIntoView(true);", address);
    address.sendKeys("11/86, Niraiyur,Dharapuram, Tirupur, Tamil Nadu 641671");
    System.out.println("Address entered");

    WebElement state = driver.findElement(By.id("state"));
    js.executeScript("arguments[0].scrollIntoView(true);", state);
    state.click();
    WebElement stateOption = driver.findElement(By.xpath("//div[text()='Haryana']"));
    js.executeScript("arguments[0].scrollIntoView(true);", stateOption);
    stateOption.click();
    System.out.println("State selected");

    WebElement city = driver.findElement(By.id("city"));
    js.executeScript("arguments[0].scrollIntoView(true);", city);
    city.click();
    WebElement cityOption = driver.findElement(By.xpath("//div[text()='Panipat']"));
    js.executeScript("arguments[0].scrollIntoView(true);", cityOption);
    cityOption.click();
    System.out.println("City selected");

    WebElement submitButton = driver.findElement(By.id("submit"));
    js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
    submitButton.click();
    System.out.println("Form submitted");

}

@AfterTest
public void afterTest() {
  driver.quit();
}

}