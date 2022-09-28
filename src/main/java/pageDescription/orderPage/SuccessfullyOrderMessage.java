package pageDescription.orderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfullyOrderMessage {
    private final WebDriver DRIVER;
    //Локатор для сообщения об успешном создании заказа
    private final By ORDER_PLACED_SUCCESSFULLY = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']");

    //конструктор
    public SuccessfullyOrderMessage(WebDriver driver) {
        this.DRIVER = driver;
    }
    //проверяем, что сообщение об успешном создании заказа отображается на экране

    public boolean isSuccessMessageVisible() {
       return DRIVER.findElement(ORDER_PLACED_SUCCESSFULLY).isDisplayed();

    }

    public String getMessageText(){
        return DRIVER.findElement(ORDER_PLACED_SUCCESSFULLY).getText();
    }


}
