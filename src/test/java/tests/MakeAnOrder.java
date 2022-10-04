package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageDescription.HomePageScooter;
import pageDescription.orderPage.ConfirmationOder;
import pageDescription.orderPage.OrderScooterAboutRent;
import pageDescription.orderPage.OrderScooterForWhomTheScooter;
import pageDescription.orderPage.SuccessfullyOrderMessage;

@RunWith(Parameterized.class)
public class MakeAnOrder extends BaseTest{
    private final String name;
    private final String surname;
    private final String address;
    private final String telephone;
    private final String deliveryDate;
    private final int rentalDays;
    private final String colourOfScooter;
    private final String commentForCourier;

    public MakeAnOrder(String name, String surname, String address, String telephone, String deliveryDate, int rentalDays, String colourOfScooter, String commentForCourier) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        this.deliveryDate = deliveryDate;
        this.rentalDays = rentalDays;
        this.colourOfScooter = colourOfScooter;
        this.commentForCourier = commentForCourier;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {"Вася", "Петров", "32478932747289347298374892374293874239874238928,.", "+79213456543", "Tomorrow", 1,"Black","do not disturb after 18"},
                {"Лариса Ивановна", "Столб", "Волхов", "89217389999","Today",3,"Grey"," "},
                {"Джек", "Воробей", "черная жемчужина", "1283213983733","Today",7," ","бесконтактная доставка"},
        };
    }


    @Test //Оформляем заказ через кнопку "Заказать" в шапке страницы
    public void makeOrderWithButtonInHead() {
        HomePageScooter homePage = new HomePageScooter(driver);
        homePage.clickButtonOrderInHead();
        OrderScooterForWhomTheScooter firstOrderPage = new OrderScooterForWhomTheScooter(driver);
        firstOrderPage.setOrderFields(name, surname, address, telephone);
        OrderScooterAboutRent secondOrderPage = new OrderScooterAboutRent(driver);
        secondOrderPage.setOrderFields(deliveryDate, rentalDays, colourOfScooter, commentForCourier);
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
        firstOrderPage.setOrderFields(name, surname, address, telephone);
        OrderScooterAboutRent secondOrderPage = new OrderScooterAboutRent(driver);
        secondOrderPage.setOrderFields(deliveryDate, rentalDays, colourOfScooter, commentForCourier);
        ConfirmationOder sayYes = new ConfirmationOder(driver);
        sayYes.clickYes();
        SuccessfullyOrderMessage successPage = new SuccessfullyOrderMessage(driver);
        successPage.isSuccessMessageVisible();
    }
}
