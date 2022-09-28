package pageDescription.orderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationOder {
    private final WebDriver DRIVER;
    //локатор для кнопки "Заказать" в шапке страницы
    private final By BUTTON_YES = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    public ConfirmationOder(WebDriver driver) {
        this.DRIVER = driver;
    }

    public void clickYes(){
        DRIVER.findElement(BUTTON_YES).click();
    }
}
