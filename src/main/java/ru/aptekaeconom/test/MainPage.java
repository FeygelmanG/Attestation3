package ru.aptekaeconom.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
//    ElementsCollection itemsBlock =
//            $$x("//div[@class=\"catalog_block items row margin0 ajax_load block\"]");
    ElementsCollection itemsBlock =
            $$x("//div[@class=\"catalog_block items row margin0 ajax_load block\"]//div[@class=\"col-m-20 col-lg-3 col-md-4 col-sm-6 item item_block\"]");

    SelenideElement basket =
            $x("//div[@class=\"wrap_icon inner-table-block baskets big-padding\"]//a[@href=\"/basket/\"]");


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
    public ElementsCollection getSubTabs(SelenideElement tab) {
        return tab.$$x("//div[@class=\"col-m-20 col-lg-3 col-md-4 col-sm-6 item item_block\"]");
    }
    public void clickBasket() {
        SelenideElement postponeGoods =
                $x("//div[@id=\"bx_3966226736_131920_HIT\"]//span[@title=\"Отложить\"]");
        postponeGoods.click();
    }

}
