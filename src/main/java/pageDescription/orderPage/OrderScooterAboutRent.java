package pageDescription.orderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderScooterAboutRent {
    private final WebDriver DRIVER;

    //Локатор для поля "Когда привезти самокат"
    private final By DATE = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Локатор для поля "Срок аренды"
    private final By RENTAL_PERIOD = By.xpath(".//div[text()='* Срок аренды']");
    //Локатор значения "сутки" поля "Срок аренды"
    private final By RENTAL_PERIOD_1_DAY = By.xpath(".//div[text()='сутки']");
    //Локатор значения "двое суток" поля "Срок аренды"
    private final By RENTAL_PERIOD_2_DAYS = By.xpath(".//div[text()='двое суток']");
    //Локатор значения "трое суток" поля "Срок аренды"
    private final By RENTAL_PERIOD_3_DAYS = By.xpath(".//div[text()='трое суток']");
    //Локатор значения "четверо суток" поля "Срок аренды"
    private final By RENTAL_PERIOD_4_DAYS = By.xpath(".//div[text()='четверо суток']");
    //Локатор значения "пятеро суток" поля "Срок аренды"
    private final By RENTAL_PERIOD_5_DAYS = By.xpath(".//div[text()='пятеро суток']");
    //Локатор значения "шестеро суток" поля "Срок аренды"
    private final By RENTAL_PERIOD_6_DAYS = By.xpath(".//div[text()='шестеро суток']");
    //Локатор значения "семеро суток" поля "Срок аренды"
    private final By RENTAL_PERIOD_7_DAYS = By.xpath(".//div[text()='семеро суток']");
    //Локатор для поля "Цвет самоката": черный жемчуг
    private final By COLOUR_BLACK = By.id("black");
    //Локатор для поля "Цвет самоката": серая безысходность
    private final By COLOUR_GREY = By.id("grey");
    //Локатор для поля "Комментарий для курьера"
    private final By COMMENT = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Локатор для кнопки "Заказать"
    private final By ORDER_BUTTON = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");

    //Конструктор
    public OrderScooterAboutRent(WebDriver driver){
        this.DRIVER = driver;
    }

    //Метод устанавливает текущую дату с помощью выбора в календаре
    public void setCurrentDate() {
        DRIVER.findElement(DATE).click();
        DRIVER.findElement(DATE).sendKeys(Keys.ENTER);
    }
    //Метод устанавливает завтрашнее число в календаре заполняя поле "Когда привезти самокат"
    public void setTomorrowDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().plusDays(1).format(formatter);
        DRIVER.findElement(DATE).sendKeys(date);
        DRIVER.findElement(DATE).sendKeys(Keys.ENTER);
    }
    //Метод устанавливает дату поле "Когда привезти самокат" 2 описанными выше способами, в зависимости от аргумента
    public void setDateOfDelivery(String deliveryDate) {
        if (deliveryDate =="Today"){
            setCurrentDate();
        }else if (deliveryDate =="Tomorrow"){
            setTomorrowDate();
        }else{
            System.out.println("Укажите дату доставки: Today или Tomorrow");
        }
    }

    //нажать на поле "Срок аренды"
    public void clickRentalPeriod() {
        DRIVER.findElement(RENTAL_PERIOD).click();
    }

    //метод устанавливает срок аренды от 1 до 7 дней в зависимости от аргумента
    public void setRentalPeriod(int days) {
        clickRentalPeriod();
        if (days ==1){
            DRIVER.findElement(RENTAL_PERIOD_1_DAY).click();
        }else if (days ==2){
            DRIVER.findElement(RENTAL_PERIOD_2_DAYS).click();
        }else if (days ==3){
            DRIVER.findElement(RENTAL_PERIOD_3_DAYS).click();
        }else if (days ==4){
            DRIVER.findElement(RENTAL_PERIOD_4_DAYS).click();
        }else if (days ==5){
            DRIVER.findElement(RENTAL_PERIOD_5_DAYS).click();
        }else if (days ==6){
            DRIVER.findElement(RENTAL_PERIOD_6_DAYS).click();
        }else if (days ==7){
            DRIVER.findElement(RENTAL_PERIOD_7_DAYS).click();
        }else{
            System.out.println("Некорректный срок аренды, задайте срок аренды числом от 1 до 7");
        }
    }
    //метод выбирает черный цвет самоката
    public void clickColourBlack() {
        DRIVER.findElement(COLOUR_BLACK).click();
    }
    //метод выбирает черный цвет самоката
    public void clickColourGrey() {
        DRIVER.findElement(COLOUR_GREY).click();
    }

    //метод выбирает черный или серый цвет самоката в зависимости от агрумента
    public void setColour(String colour) {
        if (colour =="Black"){
            clickColourBlack();
        }else if(colour =="Grey"){
            clickColourGrey();
        }
    }
    //метод заполняет поле "Комментарий для курьера"
    public void setComment(String commentText) {
        DRIVER.findElement(COMMENT).sendKeys(commentText);
    }
    //нажать на кнопку "Заказать" внизу страницы
    public void clickOrderButton() {
        DRIVER.findElement(ORDER_BUTTON).click();
    }
    //Метод заполняет страницу "Про аренду" формы заказа
    public void setOrderFields(String deliveryDate, int rentalDays, String colourOfScooter, String commentForCourier) {
        setDateOfDelivery(deliveryDate);
        setRentalPeriod(rentalDays);
        setColour(colourOfScooter);
        setComment(commentForCourier);
        clickOrderButton();
    }
}
