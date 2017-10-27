package com.ru.hugb.TicTacToe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestTTT extends SeleniumTestWrapper {
  @Test
  public void testTitle() {
    driver.get(baseUrl);
    assertEquals("TicTacToe", driver.getTitle());
  }
}
