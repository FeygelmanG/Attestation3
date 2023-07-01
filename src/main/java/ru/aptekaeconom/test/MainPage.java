package ru.aptekaeconom.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    @Step("Навести курсор на выбранную категорию")
    public void hoverCatalog(String nameCatalog) {
        SelenideElement dropdownToggle = $x("//div[contains(text(),\"" + nameCatalog + "\")]");
        dropdownToggle.shouldBe(Condition.visible).hover();
    }

    @Step("Кликнуть на выбранную подкатегорию")
    public void clickSubCatalog(String nameCatalog, String nameSubCatalog) {
        SelenideElement element =
                $x("//div[contains(text(),\"" + nameCatalog + "\")]/ancestor::div[@class=\"wrap\"]" +
                        "//li//a[@title=\"" + nameSubCatalog + "\"]")
                        .shouldBe(Condition.visible).shouldNotBe(Condition.disabled);
        element.click();
    }


}
