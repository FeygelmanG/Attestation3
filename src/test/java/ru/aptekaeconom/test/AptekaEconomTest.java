package ru.aptekaeconom.test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
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
    SearchPage searchPage = new SearchPage();
    BasketPage basketPage = new BasketPage();

    @BeforeEach
    public void setSelenide() {
        open("https://aptekaeconom.com");
        Selenide.webdriver().driver().getWebDriver().manage().addCookie(new Cookie("current_region", "103006"));
        refresh();
        cityPopup.modal.shouldNotBe(visible);
    }

//    // Тест 1 - Каталог
//    // При переходе в любую подкатегорию каталога, открывается страница хотя бы с 1 товаром в списке товаров категории.
//    // Хлебные крошки отображаются корректно, в каталогах в левой и верхней части страницы текущая подкатегория
//    // отображается корректно
//    @Test
//    @DisplayName("Переход по подкатегориям в каталоге товаров")
//    @Feature("Каталог товаров")
//    @Story("Подкатегории")
//    public void shouldOpenCatalogTab() {
//
//        step("Навести курсор на каталог \"Гигиена\"", () -> mainPage.hoverCatalog("Гигиена"));
//
//        step("Кликнуть на подкатегорию \"Детская косметика, гигиена, уход\" в каталоге \"Гигиена\"", () ->
//                mainPage.clickSubCatalog("Гигиена", "Детская косметика, гигиена, уход"));
//
//        step("Проверить, что произошел переход на страницу товаров подкатегории \"Детская косметика, гигиена, " +
//                "уход\" в каталоге \"Гигиена\" (в влевой верхней части страницы текущая подкатегория отображается " +
//                "корректно)", () -> {
//            catalogPage.pageTitle.shouldHave(text("Детская косметика, гигиена, уход"));
//        });
//
//        step("Проверить, что есть хотя бы 1 товар в списке товаров категории", () -> {
//            catalogPage.itemsBlockList.shouldBe(CollectionCondition.size(1));
//        });
//
//        step("Проверить, что хлебные крошки отображаются корректно", () -> {
//            ElementsCollection itemsBreadcrumb = catalogPage.itemsBreadcrumb;
//
//            itemsBreadcrumb.shouldBe(CollectionCondition.size(4));
//
//            itemsBreadcrumb.get(0).shouldHave(text("Главная"));
//            itemsBreadcrumb.get(1).shouldHave(text("Каталог"));
//            itemsBreadcrumb.get(2).shouldHave(text("Гигиена"));
//            itemsBreadcrumb.get(3).shouldHave(text("Детская косметика, гигиена, уход"));
//        });
//
//    }
//
//    //Тест 2 - Поиск
//    // Поиск ищет товары только по полному совпадению слова или словосочетания. В поисковой выдаче отображается по 5
//    // товаров на странице
//    @Test
//    @DisplayName("Поиск товаров по полному совпадению")
//    @Feature("Поиск товаров")
//    public void shouldSearchProductsOnlyByExact() {
//
//        step("Ввести \"фен\" в поле поиска", () -> mainPage.inputSearchText("фен"));
//
//        step("Проверить, что поиск ищет товары только по полному совпадению слова или словосочетания.", () -> {
//            ElementsCollection itemsSearch = searchPage.itemsSearch;
//            for (SelenideElement element : itemsSearch) {
//                element.shouldHave(text("фен"));
//            }
//        });
//    }
//
//    @Test
//    @DisplayName("Поиск товаров, вывод 5 позиций")
//    @Feature("Поиск товаров")
//    public void shouldSearchProductsFivePosition() {
//
//        step("Ввести \"нурофен\" в поле поиска", () -> mainPage.inputSearchText("нурофен"));
//
//        step("Проверить, что в поисковой выдаче отображается по 5 товаров на странице.", () -> {
//            ElementsCollection itemsSearch = searchPage.itemsSearch;
//            itemsSearch.shouldBe(CollectionCondition.size(5));
//        });
//    }
//
//    //Тест 3 - Отложить.
//    // Товар, который есть в наличии можно отложить, нажав на кнопку с иконкой сердечка и текстом “Отложить” на
//    // карточке товара. Отложенный товар появляется с пометкой “Товар отложен” в корзине, перейти в которую можно по
//    // кнопке в шапке. При наведении курсора на эту кнопку появляется корректный текст о сумме товаров в избранном.
//    // Отложенный товар не учитывается в итоговой сумме заказа
//    @Test
//    @DisplayName("Отложить товар, товар появляется в корзине, не учитывается в сумме заказа и выводится корректный " +
//            "текст при наведении на кнопку отложить")
//    @Feature("Отложить товар")
//    public void shouldPostponeGoods() {
//        ElementsCollection itemsBlock = mainPage.itemsBlock;
//
//        step("Проверить, что выбранный элемент в наличии по блоку \"Выбор покупателей\". Т.е есть хотя бы 1 " +
//                "элемент в блоке и у него указано\"В наличии\"", () -> {
//            itemsBlock.shouldHave(CollectionCondition.sizeGreaterThan(1));
//            itemsBlock.get(0).shouldHave(text("В наличии"));
//        });
//
//        step("Кликнуть у первого элемент в блоке \"Выбор покупателей\" на кнопку \"Отложить\"", () -> {
//            ElementsCollection itemsWish = mainPage.itemsWish;
//            itemsWish.get(0).click();
//        });
//
//        step("Сохранить цену первого товара в блоке \"Выбор покупателей\", навести курсор на иконку \"Отложено\"" +
//                ", должен появляется корректный текст о сумме товаров в избранном", () -> {
//            ElementsCollection itemsPrice = mainPage.itemsPrice;
//            mainPage.hoverPostponeGoods(itemsPrice.get(0).text());
//        });
//
//        step("Проверить, что отложенный товар появляется с пометкой “Товар отложен” в корзине", () -> {
//            String NamePostponeGood = mainPage.getNamePostponeGood();
//            mainPage.basket.click();
//            basketPage.namePostponeGood(NamePostponeGood);
//        });
//
//        step("Проверить, что отложенный товар не учитывается в итоговой сумме заказа", () -> {
//            basketPage.itemBasket.shouldBe(text("0 руб."));
//        });
//
//    }
}