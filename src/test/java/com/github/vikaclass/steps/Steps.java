package com.github.vikaclass.steps;

import com.github.vikaclass.pages.MainPage;
import com.github.vikaclass.pages.ProductsPage;
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
        MainPage mainPage = new MainPage(driver);
        String bucketCounter = mainPage.getBucketCounter();
        Assert.assertEquals("0", bucketCounter);
    }

    @Когда("^пользователь выполняет поиск товара \"([^\"]*)\"$")
    public void searceGoods (String arg1) throws Throwable {
        MainPage mainPage = new MainPage(driver);
        mainPage.search(arg1);

    }


    @И("^нажимает на красную кнопку купить$")
    public void pressedRedButtonBuy() throws Throwable {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickBuyButton();
    }

    @И("^нажимает на кнопку оформить доставку или резерв в магазине$")
    public void pressedMakeOrder() throws Throwable {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickMakeOrder();

    }

    @Тогда("^открывается корзина с одним товаром$")
    public void shouldBeOneGood() throws Throwable {
        ProductsPage productsPage = new ProductsPage(driver);
        String counter = productsPage.getBucketCounter();
        Assert.assertEquals("1",counter);

        driver.quit();//TODO: перенести в правильное место

    }

}
