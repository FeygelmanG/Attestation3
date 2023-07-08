package ru.aptekaeconom.test;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;

public class SearchPage {
    ElementsCollection itemsSearch =
            $$x("//div[@class=\"catalog_block items block_list\"]");

}
