package ru.aptekaeconom.test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AptekaEconomTest extends WebTest {

    MainPage mainPage = new MainPage();
    CityPopup cityPopup = new CityPopup();
    CatalogPage catalogPage = new CatalogPage();

    @BeforeEach
    public void setSelenide() {
        open("https://aptekaeconom.com");
        Selenide.webdriver().driver().getWebDriver().manage().addCookie(new Cookie("current_region", "103006"));
        refresh();
        cityPopup.modal.shouldNotBe(visible);
    }

    @Test
    @DisplayName("Переход по подкатегориям в каталоге товаров")
    @Feature("Каталог товаров")
    @Story("Подкатегории")
    public void shouldOpenCatalogTab() {

        step("Навести курсор на каталог \"Гигиена\"", () -> {
            mainPage.hoverCatalog("Гигиена");
        });

        step("Кликнуть на подкатегорию \"Детская косметика, гигиена, уход\" в каталоге \"Гигиена\"", () -> {
            mainPage.clickSubCatalog("Гигиена", "Детская косметика, гигиена, уход");
        });

        step("Проверить, что произошел переход на страницу товаров подкатегории \"Детская косметика, гигиена, " +
                "уход\" в каталоге \"Гигиена\" (в влевой верхней части страницы текущая подкатегория отображается " +
                "корректно)", () -> {
            catalogPage.pageTitle.shouldHave(text("Детская косметика, гигиена, уход"));
        });

        step("Проверить, что есть хотя бы 1 товар в списке товаров категории", () -> {
            catalogPage.itemsBlockList.shouldBe(CollectionCondition.size(1));
        });

        step("Проверить, что хлебные крошки отображаются корректно", () -> {
//            catalogPage.itemsBreadcrumb.shouldBe(CollectionCondition.size(4));
            ElementsCollection temsBreadcrumb = catalogPage.itemsBreadcrumb;

            temsBreadcrumb.get(0).shouldHave(text("Главная"));
            temsBreadcrumb.get(1).shouldHave(text("Каталог"));
        });

    }
}
