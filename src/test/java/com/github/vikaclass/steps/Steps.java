package com.github.vikaclass.steps;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;

public class Steps {
    @Дано("^пользователь зашел на сайт$")
    public void userOnSite() {
        System.out.println("пользователь зашел на сайт");
    }

    @И("^у него пустая корзина$")
    public void bucketIsEmpty() throws Throwable {
        System.out.println("у_него_пустая_корзина");
    }

    @Когда("^пользователь заполняет поле поиска товара \"([^\"]*)\"$")
    public void searceGoods (String arg1) throws Throwable {
        System.out.println("пользователь_заполняет_поле_поиска_товара");
    }

    @И("^нажимает на кнопку enter$")
    public void pressedEnter() throws Throwable {
        System.out.println("нажимает_на_кнопку_enter");
    }

    @И("^нажимает на оранжевую кнопку купить$")
    public void pressedOrangeButtonBuy() throws Throwable {
        System.out.println("нажимает_на_оранжевую_кнопку_купить");
    }

    @И("^нажимает на кнопку оформить доставку или резерв в магазине$")
    public void pressedMakeOrder() throws Throwable {
        System.out.println("нажимает_на_кнопку_оформить_доставку_или_резерв_в_магазине");
    }

    @Тогда("^открывается корзина с одним товаром$")
    public void shouldBeOneGood() throws Throwable {
        System.out.println("открывается_корзина_с_одним_товаром");
    }

}
