package pageDescription.orderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderScooterForWhomTheScooter {
    private final WebDriver driver;
    //Локатор для поля "Имя"
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Локатор для поля "Фамилия"
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Локатор для поля "Адрес"
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор для поля "Станция метро"
    private final By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    //Локатор для поля "Телефон"
    private final By telephoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор для кнопки "Далее"
    private final By nextButton = By.xpath(".//div[@class = 'Order_NextButton__1_rCA']/button[text() = 'Далее']");

    //Конструктор
    public OrderScooterForWhomTheScooter(WebDriver driver){
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }
    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    //Устанавливаем значение поля "Станция метро"
    public void setMetroStation() {
        driver.findElement(metroStationField).click();
        driver.findElement(metroStationField).sendKeys(Keys.DOWN);
        driver.findElement(metroStationField).sendKeys(Keys.ENTER);
    }
    public void setTelephone(String telephone) {
        driver.findElement(telephoneField).sendKeys(telephone);
    }
    //Нажимаем на кнопку "Далее"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
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
