package testsForFirefox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageDescription.HomePageScooter;

public class TestsForQuestions {
    private WebDriver driver;

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
    @Test
    public void questionAboutPrice() {
        // создаем объект класса главной страницы приложения
        HomePageScooter homePage =new HomePageScooter(driver);
        //кликаем на вопрос
        homePage.clickQuestionPrice();
        //проверяем правильность ответа
        homePage.checkQuestionTextForPrice();
        System.out.println(driver.findElement(By.xpath(".//div[@id='accordion__panel-0']")).getText());
    }

    @Test
    public void questionAboutLeaseSeveralScooters() {
        // создаем объект класса главной страницы приложения
        HomePageScooter homePage =new HomePageScooter(driver);
        //кликаем на вопрос
        homePage.clickQuestionSeveralScooters();
        //проверяем правильность ответа
        homePage.checkQuestionTextForSeveralScooters();
        System.out.println(driver.findElement(By.xpath(".//div[@id='accordion__panel-1']")).getText());
    }
    @Test
    public void questionAboutRentalTime() {
        // создаем объект класса главной страницы приложения
        HomePageScooter homePage =new HomePageScooter(driver);
        //кликаем на вопрос
        homePage.clickQuestionRentalTime();
        //проверяем правильность ответа
        homePage.checkQuestionTextForRentalTime();
        System.out.println(driver.findElement(By.xpath(".//div[@id='accordion__panel-2']")).getText());
    }
    @Test
    public void questionAboutUrgentOrder() {
        // создаем объект класса главной страницы приложения
        HomePageScooter homePage =new HomePageScooter(driver);
        //кликаем на вопрос
        homePage.clickQuestionUrgentOrder();
        //проверяем правильность ответа
        homePage.checkQuestionTextForUrgentOrder();
        System.out.println(driver.findElement(By.xpath(".//div[@id='accordion__panel-3']")).getText());
    }
    @Test
    public void questionAboutExtendOrder() {
        // создаем объект класса главной страницы приложения
        HomePageScooter homePage =new HomePageScooter(driver);
        //кликаем на вопрос
        homePage.clickQuestionExtendOrder();
        //проверяем правильность ответа
        homePage.checkQuestionTextForExtendOrder();
        System.out.println(driver.findElement(By.xpath(".//div[@id='accordion__panel-4']")).getText());
    }
    @Test
    public void questionAboutAvailabilityCharging() {
        // создаем объект класса главной страницы приложения
        HomePageScooter homePage =new HomePageScooter(driver);
        //кликаем на вопрос
        homePage.clickQuestionAvailabilityCharging();
        //проверяем правильность ответа
        homePage.checkQuestionTextForAvailabilityCharging();
        System.out.println(driver.findElement(By.xpath(".//div[@id='accordion__panel-5']")).getText());
    }

    @Test
    public void questionAboutCancelOrder() {
        // создаем объект класса главной страницы приложения
        HomePageScooter homePage =new HomePageScooter(driver);
        //кликаем на вопрос
        homePage.clickQuestionCancelOrder();
        //проверяем правильность ответа
        homePage.checkQuestionTextForCancelOrder();
        System.out.println(driver.findElement(By.xpath(".//div[@id='accordion__panel-6']")).getText());
    }
    @Test
    public void questionAboutAvailableDistance() {
        // создаем объект класса главной страницы приложения
        HomePageScooter homePage =new HomePageScooter(driver);
        //кликаем на вопрос
        homePage.clickQuestionAvailableDistance();
        //проверяем правильность ответа
        homePage.checkQuestionTextForAvailableDistance();
        System.out.println(driver.findElement(By.xpath(".//div[@id='accordion__panel-7']")).getText());
    }

    @After // закрываем браузер
    public void closeFirefox() {
        driver.quit();
    }
}
