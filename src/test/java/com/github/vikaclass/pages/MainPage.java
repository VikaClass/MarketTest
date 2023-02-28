package com.github.vikaclass.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class MainPage {
    private final WebDriver webDriver;
    private By mainSearch = By.id("search-main");
    private  By bucketCounter = By.id("in-cart-count-icon");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getBucketCounter() {
        return webDriver.findElement(bucketCounter).getText();
    }

    public void search(String searchText) {
        WebElement searchElement = webDriver.findElement(mainSearch);
        searchElement.sendKeys(searchText);
        searchElement.sendKeys(Keys.ENTER);
    }
}
