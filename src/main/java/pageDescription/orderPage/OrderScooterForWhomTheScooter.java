package pageDescription.orderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderScooterForWhomTheScooter {
    private final WebDriver DRIVER;
    //Локатор для поля "Имя"
    private final By NAME_FIELD = By.xpath(".//input[@placeholder='* Имя']");
    //Локатор для поля "Фамилия"
    private final By SURNAME_FIELD = By.xpath(".//input[@placeholder='* Фамилия']");
    //Локатор для поля "Адрес"
    private final By ADDRESS_FIELD = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор для поля "Станция метро"
    private final By METRO_STATION_FIELD = By.xpath(".//input[@placeholder='* Станция метро']");
    //Локатор для поля "Телефон"
    private final By TELEPHONE_FIELD = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор для кнопки "Далее"
    private final By NEXT_BUTTON = By.xpath(".//div[@class = 'Order_NextButton__1_rCA']/button[text() = 'Далее']");

    //Конструктор
    public OrderScooterForWhomTheScooter(WebDriver driver){
        this.DRIVER = driver;
    }

    public void setName(String name) {
        DRIVER.findElement(NAME_FIELD).sendKeys(name);
    }
    public void setSurname(String surname) {
        DRIVER.findElement(SURNAME_FIELD).sendKeys(surname);
    }
    public void setAddress(String address) {
        DRIVER.findElement(ADDRESS_FIELD).sendKeys(address);
    }
    //Устанавливаем значение поля "Станция метро"
    public void setMetroStation() {
        DRIVER.findElement(METRO_STATION_FIELD).click();
        DRIVER.findElement(METRO_STATION_FIELD).sendKeys(Keys.DOWN);
        DRIVER.findElement(METRO_STATION_FIELD).sendKeys(Keys.ENTER);
    }
    //Если при установке станции метро вводить ее с клавиатуры, а потом нажимать ENTER, то сайт виснет, это метод, чтобы создать тест на этот баг, правда в тз нет такого задания
    public void setMetroStationKeys(String metroStation) {
        DRIVER.findElement(METRO_STATION_FIELD).sendKeys(metroStation);
    DRIVER.findElement(METRO_STATION_FIELD).sendKeys(Keys.ENTER);
    }
    public void setTelephone(String telephone) {
        DRIVER.findElement(TELEPHONE_FIELD).sendKeys(telephone);
    }
    //Нажимаем на кнопку "Далее"
    public void clickNextButton() {
        DRIVER.findElement(NEXT_BUTTON).click();
    }
    //Метод заполняет страницу заказа "Для кого самокат"
    public void setOrderFields(String name, String surname, String address, String telephone){
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetroStation();
        setTelephone(telephone);
        clickNextButton();
    }
}
