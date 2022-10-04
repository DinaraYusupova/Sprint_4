package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
    protected final String scooterUrl = "https://qa-scooter.praktikum-services.ru/";


    @Before
    public void openHomePage() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get(scooterUrl);
        //закрываем сообщение про cookies
        driver.findElement(By.cssSelector(".App_CookieButton__3cvqF")).click();
    }
    @After // закрываем браузер
    public void closeChrome() {
        driver.quit();
    }
}
