package com.github.vikaclass.steps;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {
    static { //TODO перенестив правильное место
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver110\\chromedriver.exe");
    }
    WebDriver driver = new ChromeDriver();
    @Дано("^пользователь зашел на сайт$")
    public void userOnSite() {

        driver.get("https://www.pleer.ru/");

    }

    @И("^у него пустая корзина$")
    public void bucketIsEmpty() throws Throwable {
        WebElement itemCount = driver.findElement(By.id("in-cart-count-icon"));
        String itemCountText = itemCount.getText();
        Assert.assertEquals("0", itemCountText);
    }

    @Когда("^пользователь заполняет поле поиска товара \"([^\"]*)\"$")
    public void searceGoods (String arg1) throws Throwable {
        WebElement searchMain = driver.findElement(By.xpath("//*[@id=\"search-main\"]"));
        searchMain.sendKeys(arg1);
    }

    @И("^нажимает на кнопку enter$")
    public void pressedEnter() throws Throwable {
        WebElement searchMain = driver.findElement(By.id("search-main"));
        searchMain.sendKeys(Keys.ENTER);
    }

    @И("^нажимает на красную кнопку купить$")
    public void pressedRedButtonBuy() throws Throwable {
        WebElement buyButton = driver.findElement(By.xpath("//*[@id=\"list_items\"]/div[1]/div[2]/div[2]/div[4]/div/div[3]"));
        buyButton.click();
    }

    @И("^нажимает на кнопку оформить доставку или резерв в магазине$")
    public void pressedMakeOrder() throws Throwable {
        Thread.sleep(1000);//TODO: избавиться от неправильного ожидания
        WebElement orderButton = driver.findElement(By.xpath("//*[@id=\"minicart\"]/div/div/div[2]/div[3]/div[1]/div/a/div"));
        orderButton.click();
    }

    @Тогда("^открывается корзина с одним товаром$")
    public void shouldBeOneGood() throws Throwable {
        WebElement countElement = driver.findElement(By.id("h-cart-count"));
        String countString = countElement.getText();
        Assert.assertEquals("1",countString);

        driver.quit();//TODO: перенести в правильное место

    }

}
