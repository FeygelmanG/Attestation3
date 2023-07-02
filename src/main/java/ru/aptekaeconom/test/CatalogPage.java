package ru.aptekaeconom.test;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {

    SelenideElement pageTitle = $("h1");
    ElementsCollection itemsBlockList =
            $$x("//div[@class=\"catalog_block items block_list\"]");

    ElementsCollection itemsBreadcrumb =
            $$x("//span[@itemprop=\"name\"]");

}
