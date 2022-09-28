package testsForFirefox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageDescription.HomePageScooter;

import java.util.ArrayList;

public class ClickOnLogo {
    private WebDriver driver;
    private final String SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/";
    private final String YANDEX_URL = "https://dzen.ru/?yredirect=true";


    @Before
    public void openHomePageInFirefox() {
        WebDriverManager.firefoxdriver().setup();
        // драйвер для браузера FireFox
        driver = new FirefoxDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
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


    // Тест не имеет смысла, т.к. FireFox прекратил поддержку поиска Яндекса, о чем вывесил банер при переходе на страницу Яндекса. Поэтому тест падает.
//    @Test //Тест проверяет, что при нажатии на логотип "Яндекс", в новом окне откроется главная страница Яндекса.
//    public void clickOnLogoYandex() {
//        //Проверяем количество открытых вкладок
//        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//        System.out.println(tabs.size());
//        String currentUrl1 = driver.getCurrentUrl();
//        System.out.println(currentUrl1);
//        //Нажимаем на логотип Яндекса
//        HomePageScooter homePage = new HomePageScooter(driver);
//        homePage.clickLogoYandex();
//        System.out.println("кликнули");
//        //Проверяем, что вкладок стало на 1 больше и что открылась страница Яндекса
//        ArrayList<String> postTabs = new ArrayList<String> (driver.getWindowHandles());
//        System.out.println(postTabs.size());
//        driver.switchTo().window(postTabs.get(1));
//        System.out.println("переключились");
//        String currentUrl = driver.getCurrentUrl();
//        System.out.println(currentUrl);
//        Assert.assertTrue("URL не совпадает с URL Яндекса",currentUrl.equals(YANDEX_URL));
//        Assert.assertEquals("Не совпадает количество открытых вкладок с ожидаемым, после перехода на страницу Яндекса",(tabs.size()+1),postTabs.size());
//    }

    @After // закрываем браузер
    public void closeFirefox() {
        driver.quit();
    }
    }
