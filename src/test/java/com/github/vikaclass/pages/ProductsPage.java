package com.github.vikaclass.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

    private final WebDriver webDriver;
    private By firstItem = By.xpath("//*[@id=\"list_items\"]/div[1]/div[2]/div[2]/div[4]/div/div[3]");
    private By makeOrderButton = (By.xpath("//*[@id=\"minicart\"]/div/div/div[2]/div[3]/div[1]/div/a/div"));

    private By bucketCounter = By.id("h-cart-count");

    public ProductsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickBuyButton() {

        WebElement buyButton = webDriver.findElement(firstItem);
        buyButton.click();
    }

    public void clickMakeOrder() {
        try {
            Thread.sleep(1000);//TODO: избавиться от неправильного ожидания
        } catch (Exception e) {

        }

        WebElement orderButton = webDriver.findElement(makeOrderButton);
        orderButton.click();

    }
    public String getBucketCounter(){
        WebElement countElement = webDriver.findElement(bucketCounter);

        return countElement.getText();
    }
}
