package ru.aptekaeconom.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {

    SelenideElement pageTitle = $("h1");
    ElementsCollection itemsBlockList =
            $$x("//div[@class=\"catalog_block items block_list\"]");

    ElementsCollection itemsBreadcrumb =
            $$x("//meta[@itemprop=\"name\"]");
//    $$x("//div[@class=\"bx-breadcrumb-item bx-breadcrumb-item--mobile\"]");

}
