package tests;

import org.junit.Assert;
import org.junit.Test;
import pageDescription.HomePageScooter;
import java.util.ArrayList;

public class ClickOnLogo extends BaseTest {
    private final String yandexUrl = "https://dzen.ru/?yredirect=true";

    @Test //Тест проверяет, что при нажатии на логотип "Самокат", попадаешь на главную страницу «Самоката».
    public void clickOnLogoScooter() {
        //Переходим с основной страницы сайта на страницу заказа
        HomePageScooter homePage = new HomePageScooter(driver);
        homePage.clickButtonOrderInHead();
        //Нажимаем на логотип "Самокат" и проверяем, что URL равен URL главной страниицы
        homePage.clickLogoScooter();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("Текущий URL не совпадает с URL главной страницы самоката", scooterUrl, currentUrl);
    }

    @Test //Тест проверяет, что при нажатии на логотип "Яндекс", в новом окне откроется главная страница Яндекса.
    public void clickOnLogoYandex() {
        //Проверяем количество открытых вкладок
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        //Нажимаем на логотип Яндекса
        HomePageScooter homePage = new HomePageScooter(driver);
        homePage.clickLogoYandex();
        //Проверяем, что вкладок стало на 1 больше и что открылась страница Яндекса
        ArrayList<String> postTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(postTabs.get(1));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("URL не совпадает с URL Яндекса", yandexUrl, currentUrl);
        Assert.assertEquals("Не совпадает количество открытых вкладок с ожидаемым, после перехода на страницу Яндекса", (tabs.size() + 1), postTabs.size());

    }
}