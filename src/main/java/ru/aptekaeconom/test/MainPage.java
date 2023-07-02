package ru.aptekaeconom.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    ElementsCollection itemsBlock =
            $$x("//div[@class=\"catalog_block items row margin0 ajax_load block\"]");

    @Step("Навести курсор на выбранную категорию")
    public void hoverCatalog(String nameCatalog) {
        SelenideElement dropdownToggle = $x("//div[contains(text(),\"" + nameCatalog + "\")]");
        dropdownToggle.shouldBe(Condition.visible).hover();
    }

    @Step("Кликнуть на выбранную подкатегорию")
    public void clickSubCatalog(String nameCatalog, String nameSubCatalog) {
        SelenideElement elementSubCatalog =
                $x("//div[contains(text(),\"" + nameCatalog + "\")]/ancestor::div[@class=\"wrap\"]" +
                        "//li//a[@title=\"" + nameSubCatalog + "\"]")
                        .shouldBe(Condition.visible).shouldNotBe(Condition.disabled);
        elementSubCatalog.click();
    }

    @Step("Ввести указанный текст в поле поиска")
    public void inputSearchText(String searchText) {
        SelenideElement searchField = $x("//input[@id=\"title-search-input_fixed\"]");
        searchField.sendKeys(searchText);
        SelenideElement magnifier = $x("//i[@class=\"svg svg-search svg-black\"]");
        magnifier.click();
    }

//    @Step("Кликнуть на выбранную подкатегорию")
//    public void clickPostponeGoods() {
//        ElementsCollection itemsBlock =
//                $$x("//div[@class=\"catalog_block items row margin0 ajax_load block\"]");
//    }

}
