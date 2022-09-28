package testsRorChrome;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageDescription.HomePageScooter;

import java.util.ArrayList;

public class ClickOnLogo {
    private WebDriver driver;
    private final String SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/";
    private final String YANDEX_URL = "https://dzen.ru/?yredirect=true";


    @Before
    public void openHomePageInChrome() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get(SCOOTER_URL);
        //закрываем сообщение про cookies
        driver.findElement(By.cssSelector(".App_CookieButton__3cvqF")).click();
    }

    @Test //Тест проверяет, что при нажатии на логотип "Самокат", попадаешь на главную страницу «Самоката».
    public void clickOnLogoScooter() {
        //Переходим с основной страницы сайта на страницу заказа
        HomePageScooter homePage = new HomePageScooter(driver);
        homePage.clickButtonOrderInHead();
        //Нажимаем на логотип "Самокат" и проверяем, что URL равен URL главной страниицы
        homePage.clickLogoScooter();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Текущий URL не совпадает с URL главной страницы самоката",currentUrl.equals(SCOOTER_URL));
    }

    @Test //Тест проверяет, что при нажатии на логотип "Яндекс", в новом окне откроется главная страница Яндекса.
    public void clickOnLogoYandex() {
        //Проверяем количество открытых вкладок
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        //Нажимаем на логотип Яндекса
        HomePageScooter homePage = new HomePageScooter(driver);
        homePage.clickLogoYandex();
        //Проверяем, что вкладок стало на 1 больше и что открылась страница Яндекса
        ArrayList<String> postTabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(postTabs.get(1));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("URL не совпадает с URL Яндекса",currentUrl.equals(YANDEX_URL));
        Assert.assertEquals("Не совпадает количество открытых вкладок с ожидаемым, после перехода на страницу Яндекса",(tabs.size()+1),postTabs.size());

    }

    @After // закрываем браузер
    public void closeChrome() {
        driver.quit();
    }
    }
