package com.ru.hugb.TicTacToe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestTTT extends SeleniumTestWrapper {
  @Test
  public void testTitle() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    assertEquals("TicTacToe", driver.getTitle());
  }
}
