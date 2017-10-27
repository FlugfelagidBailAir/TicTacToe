package com.ru.hugb.TicTacToe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public abstract class SeleniumTestWrapper {
  //static WebDriver driver;
  static ChromeDriver driver;

  static String baseUrl;
  static String port;

  @BeforeClass
  public static void openBrowser() {
    //System.setProperty("webdriver.gecko.driver", "/Users/Godi/Downloads/geckodriver");
    //driver = new FirefoxDriver();
    //baseUrl = "https://frozen-springs-99760.herokuapp.com/";
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    port = System.getenv("PORT");
    if (port == null) {
        port = "4567";
    }
    baseUrl = "http://localhost:4567";

    driver.get(baseUrl);
  }

  @AfterClass
  public static void closeBrowser(){
    driver.quit();
  }
}
