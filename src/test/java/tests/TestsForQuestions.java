package tests;

import org.openqa.selenium.By;
import org.junit.Test;
import pageDescription.HomePageScooter;

public class TestsForQuestions extends BaseTest {

    @Test
    public void questionAboutPrice() {
        // создаем объект класса главной страницы приложения
        HomePageScooter homePage = new HomePageScooter(driver);
        //кликаем на вопрос
        homePage.clickQuestionPrice();
        //проверяем правильность ответа
        homePage.checkQuestionTextForPrice();
        System.out.println(driver.findElement(By.xpath(".//div[@id='accordion__panel-0']")).getText());
    }

    @Test
    public void questionAboutLeaseSeveralScooters() {
        // создаем объект класса главной страницы приложения
        HomePageScooter homePage = new HomePageScooter(driver);
        //кликаем на вопрос
        homePage.clickQuestionSeveralScooters();
        //проверяем правильность ответа
        homePage.checkQuestionTextForSeveralScooters();
        System.out.println(driver.findElement(By.xpath(".//div[@id='accordion__panel-1']")).getText());
    }

    @Test
    public void questionAboutRentalTime() {
        // создаем объект класса главной страницы приложения
        HomePageScooter homePage = new HomePageScooter(driver);
        //кликаем на вопрос
        homePage.clickQuestionRentalTime();
        //проверяем правильность ответа
        homePage.checkQuestionTextForRentalTime();
        System.out.println(driver.findElement(By.xpath(".//div[@id='accordion__panel-2']")).getText());
    }

    @Test
    public void questionAboutUrgentOrder() {
        // создаем объект класса главной страницы приложения
        HomePageScooter homePage = new HomePageScooter(driver);
        //кликаем на вопрос
        homePage.clickQuestionUrgentOrder();
        //проверяем правильность ответа
        homePage.checkQuestionTextForUrgentOrder();
        System.out.println(driver.findElement(By.xpath(".//div[@id='accordion__panel-3']")).getText());
    }

    @Test
    public void questionAboutExtendOrder() {
        // создаем объект класса главной страницы приложения
        HomePageScooter homePage = new HomePageScooter(driver);
        //кликаем на вопрос
        homePage.clickQuestionExtendOrder();
        //проверяем правильность ответа
        homePage.checkQuestionTextForExtendOrder();
        System.out.println(driver.findElement(By.xpath(".//div[@id='accordion__panel-4']")).getText());
    }

    @Test
    public void questionAboutAvailabilityCharging() {
        // создаем объект класса главной страницы приложения
        HomePageScooter homePage = new HomePageScooter(driver);
        //кликаем на вопрос
        homePage.clickQuestionAvailabilityCharging();
        //проверяем правильность ответа
        homePage.checkQuestionTextForAvailabilityCharging();
        System.out.println(driver.findElement(By.xpath(".//div[@id='accordion__panel-5']")).getText());
    }

    @Test
    public void questionAboutCancelOrder() {
        // создаем объект класса главной страницы приложения
        HomePageScooter homePage = new HomePageScooter(driver);
        //кликаем на вопрос
        homePage.clickQuestionCancelOrder();
        //проверяем правильность ответа
        homePage.checkQuestionTextForCancelOrder();
        System.out.println(driver.findElement(By.xpath(".//div[@id='accordion__panel-6']")).getText());
    }

    @Test
    public void questionAboutAvailableDistance() {
        // создаем объект класса главной страницы приложения
        HomePageScooter homePage = new HomePageScooter(driver);
        //кликаем на вопрос
        homePage.clickQuestionAvailableDistance();
        //проверяем правильность ответа
        homePage.checkQuestionTextForAvailableDistance();
        System.out.println(driver.findElement(By.xpath(".//div[@id='accordion__panel-7']")).getText());
    }
}
