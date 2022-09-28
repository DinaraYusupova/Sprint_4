package testsRorChrome;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageDescription.HomePageScooter;
import pageDescription.orderPage.ConfirmationOder;
import pageDescription.orderPage.OrderScooterAboutRent;
import pageDescription.orderPage.OrderScooterForWhomTheScooter;
import pageDescription.orderPage.SuccessfullyOrderMessage;

import java.util.ArrayList;

public class test {
    private WebDriver driver;
    private By scooter = By.xpath(".//img[@alt = 'Scooter']");
    private By Yandex = By.xpath(".//img[@alt = 'Yandex']");

    @Test
    public void openHomePageInChrome() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //закрываем сообщение про cookies
        driver.findElement(By.cssSelector(".App_CookieButton__3cvqF")).click();
        String url = driver.getCurrentUrl();
        System.out.println(url);
        HomePageScooter homePage = new HomePageScooter(driver);
        homePage.clickButtonOrderInHead();
      //  new WebDriverWait(driver, 10);
        String url2 = driver.getCurrentUrl();
        System.out.println(url2);
        System.out.println(driver.findElement(scooter));
        driver.findElement(scooter).click();
        String url3 = driver.getCurrentUrl();
        System.out.println(url3);
        Assert.assertTrue("Cnhfybwf yt jnrhskfcm",url3.equals(url));

    }

    @Test
    public void openHomePageInChrome2() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //закрываем сообщение про cookies
        driver.findElement(By.cssSelector(".App_CookieButton__3cvqF")).click();
        String url = driver.getCurrentUrl();
        System.out.println(url);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        System.out.println(tabs2);
        System.out.println(tabs2.size());


        driver.findElement(Yandex).click();
        tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        String url3 = driver.getCurrentUrl();
        System.out.println(url3);
        Assert.assertNotEquals("Cnhfybwf yt jnrhskfcm",url,url3);
        Assert.assertTrue("123",url3.equals("https://dzen.ru/?yredirect=true"));
        System.out.println(tabs2);
        System.out.println(tabs2.size());


    }

}
