package pageDescription.orderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationOder {
    private final WebDriver driver;
    //локатор для кнопки "Заказать" в шапке страницы
    private final By buttonYes = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    public ConfirmationOder(WebDriver driver) {
        this.driver = driver;
    }

    public void clickYes(){
        driver.findElement(buttonYes).click();
    }
}
