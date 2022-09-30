package pageDescription.orderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfullyOrderMessage {
    private final WebDriver driver;
    //Локатор для сообщения об успешном создании заказа
    private final By orderPlacedSuccessfully = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']");

    //конструктор
    public SuccessfullyOrderMessage(WebDriver driver) {
        this.driver = driver;
    }
    //проверяем, что сообщение об успешном создании заказа отображается на экране

    public boolean isSuccessMessageVisible() {
       return driver.findElement(orderPlacedSuccessfully).isDisplayed();

    }

    public String getMessageText(){
        return driver.findElement(orderPlacedSuccessfully).getText();
    }

}
