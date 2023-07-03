package ru.aptekaeconom.test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;

public class BasketPage {

    ElementsCollection itemsBasket =
            $$x("//tr[@class=\"basket-items-list-item-container\"]");
}
