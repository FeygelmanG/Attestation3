package ru.aptekaeconom.test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class BasketPage {

    SelenideElement itemBasket =
            $x("//div[@class=\"basket-coupon-block-total-price-current\"]");

}
