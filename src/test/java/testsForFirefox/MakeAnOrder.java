package testsForFirefox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageDescription.HomePageScooter;
import pageDescription.orderPage.ConfirmationOder;
import pageDescription.orderPage.OrderScooterAboutRent;
import pageDescription.orderPage.OrderScooterForWhomTheScooter;
import pageDescription.orderPage.SuccessfullyOrderMessage;

@RunWith(Parameterized.class)
public class MakeAnOrder {
    private WebDriver driver;
    private final String NAME;
    private final String SURNAME;
    private final String ADDRESS;
    private final String TELEPHONE;
    private final String DELIVERY_DATE;
    private final int RENTAL_DAYS;
    private final String COLOUR_OF_SCOOTER;
    private final String COMMENT_FOR_COURIER;

    public MakeAnOrder(String name, String surname, String address, String telephone, String deliveryDate, int rentalDays, String colourOfScooter, String commentForCourier) {
        this.NAME = name;
        this.SURNAME = surname;
        this.ADDRESS = address;
        this.TELEPHONE = telephone;
        this.DELIVERY_DATE = deliveryDate;
        this.RENTAL_DAYS = rentalDays;
        this.COLOUR_OF_SCOOTER = colourOfScooter;
        this.COMMENT_FOR_COURIER = commentForCourier;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {"Вася", "Петров", "32478932747289347298374892374293874239874238928,.", "+79213456543", "Tomorrow", 1,"Black","do not disturb after 18"},
                {"Лариса Ивановна", "Столб", "Волхов", "89217389999","Today",3,"Grey"," "},
                {"Джек", "Воробей", "черная жемчужина", "1283213983733","Today",7," ","бесконтактная доставка"},
        };
    }

    @Before //Открываем в Firefox сайт, принимаем cookies
    public void openHomePageInFirefox() {
        WebDriverManager.firefoxdriver().setup();
        // драйвер для браузера FireFox
        driver = new FirefoxDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //закрываем сообщение про cookies
        driver.findElement(By.cssSelector(".App_CookieButton__3cvqF")).click();
    }
    @Test //Оформляем заказ через кнопку "Заказать" в шапке страницы
    public void makeOrderWithButtonInHead () {
        HomePageScooter homePage = new HomePageScooter(driver);
        homePage.clickButtonOrderInHead();
        OrderScooterForWhomTheScooter firstOrderPage = new OrderScooterForWhomTheScooter(driver);
        firstOrderPage.setOrderFields(NAME, SURNAME, ADDRESS, TELEPHONE);
        OrderScooterAboutRent secondOrderPage = new OrderScooterAboutRent(driver);
        secondOrderPage.setOrderFields(DELIVERY_DATE, RENTAL_DAYS, COLOUR_OF_SCOOTER, COMMENT_FOR_COURIER);
        ConfirmationOder sayYes = new ConfirmationOder(driver);
        sayYes.clickYes();
        SuccessfullyOrderMessage successPage = new SuccessfullyOrderMessage(driver);
        successPage.isSuccessMessageVisible();
        }

    @Test //Оформляем заказ через кнопку "Заказать" внизу страницы
    public void makeOrderWithButtonInTheEnd () {
        HomePageScooter homePage = new HomePageScooter(driver);
        homePage.clickButtonOrderInTheEnd();
        OrderScooterForWhomTheScooter firstOrderPage = new OrderScooterForWhomTheScooter(driver);
        firstOrderPage.setOrderFields(NAME, SURNAME, ADDRESS, TELEPHONE);
        OrderScooterAboutRent secondOrderPage = new OrderScooterAboutRent(driver);
        secondOrderPage.setOrderFields(DELIVERY_DATE, RENTAL_DAYS, COLOUR_OF_SCOOTER, COMMENT_FOR_COURIER);
        ConfirmationOder sayYes = new ConfirmationOder(driver);
        sayYes.clickYes();
        SuccessfullyOrderMessage successPage = new SuccessfullyOrderMessage(driver);
        successPage.isSuccessMessageVisible();
    }

    @After // закрываем браузер
              public void closeFirefox() {
        driver.quit();
    }
    }
