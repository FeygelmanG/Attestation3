package ru.aptekaeconom.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class BasketPage {

    SelenideElement itemBasket =
            $x("//div[@class=\"basket-coupon-block-total-price-current\"]");
    @Step("Проверить соответсвие имени отложенного товара и товара в корзине")
    public void namePostponeGood(String namePostponeGood) {
        ElementsCollection basketGoods =
                $$x("//table[@class=\"basket-items-list-table\"]//img[@class=\"basket-item-image lazyloaded\"]");
        basketGoods.get(0).shouldBe(Condition.attribute("alt", namePostponeGood));
    }

}
