package pageDescription.orderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderScooterAboutRent {
    private final WebDriver driver;

    //Локатор для поля "Когда привезти самокат"
    private final By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Локатор для поля "Срок аренды"
    private final By rentalPeriod = By.xpath(".//div[text()='* Срок аренды']");
    //Локатор значения "сутки" поля "Срок аренды"
    private final By rentalPeriod1Day = By.xpath(".//div[text()='сутки']");
    //Локатор значения "двое суток" поля "Срок аренды"
    private final By rentalPeriod2Days = By.xpath(".//div[text()='двое суток']");
    //Локатор значения "трое суток" поля "Срок аренды"
    private final By rentalPeriod3Days = By.xpath(".//div[text()='трое суток']");
    //Локатор значения "четверо суток" поля "Срок аренды"
    private final By rentalPeriod4Days = By.xpath(".//div[text()='четверо суток']");
    //Локатор значения "пятеро суток" поля "Срок аренды"
    private final By rentalPeriod5Days = By.xpath(".//div[text()='пятеро суток']");
    //Локатор значения "шестеро суток" поля "Срок аренды"
    private final By rentalPeriod6Days = By.xpath(".//div[text()='шестеро суток']");
    //Локатор значения "семеро суток" поля "Срок аренды"
    private final By rentalPeriod7Days = By.xpath(".//div[text()='семеро суток']");
    //Локатор для поля "Цвет самоката": черный жемчуг
    private final By colourBlack = By.id("black");
    //Локатор для поля "Цвет самоката": серая безысходность
    private final By colourGrey = By.id("grey");
    //Локатор для поля "Комментарий для курьера"
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Локатор для кнопки "Заказать"
    private final By orderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");

    //Конструктор
    public OrderScooterAboutRent(WebDriver driver){
        this.driver = driver;
    }


    //Метод устанавливает текущую дату с помощью выбора в календаре
    public void setCurrentDate() {
        driver.findElement(date).click();
        driver.findElement(date).sendKeys(Keys.ENTER);
    }
    //Метод устанавливает завтрашнее число в календаре заполняя поле "Когда привезти самокат"
    public void setTomorrowDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().plusDays(1).format(formatter);
        driver.findElement(this.date).sendKeys(date);
        driver.findElement(this.date).sendKeys(Keys.ENTER);
    }
    //Метод устанавливает дату поле "Когда привезти самокат" 2 описанными выше способами, в зависимости от аргумента
    public void setDateOfDelivery(String deliveryDate) {
        switch (deliveryDate) {
            case "Today":
                setCurrentDate();
                break;
            case "Tomorrow":
                setTomorrowDate();
                break;
            default:
                System.out.println("Укажите дату доставки: Today или Tomorrow");
                break;}
    }
    //нажать на поле "Срок аренды"
    public void clickRentalPeriod() {
        driver.findElement(rentalPeriod).click();
    }
    //метод устанавливает срок аренды от 1 до 7 дней в зависимости от аргумента
    public void setRentalPeriod(int days) {
        clickRentalPeriod();
        switch (days) {
            case 1:
                driver.findElement(rentalPeriod1Day).click();
                break;
            case 2:
                driver.findElement(rentalPeriod2Days).click();
                break;
            case 3:
                driver.findElement(rentalPeriod3Days).click();
                break;
            case 4:
                driver.findElement(rentalPeriod4Days).click();
                break;
            case 5:
                driver.findElement(rentalPeriod5Days).click();
                break;
            case 6:
                driver.findElement(rentalPeriod6Days).click();
                break;
            case 7:
                driver.findElement(rentalPeriod7Days).click();
                break;
            default:
                System.out.println("Некорректный срок аренды, задайте срок аренды числом от 1 до 7");
                break;
        }
    }
    //метод выбирает черный цвет самоката
    public void clickColourBlack() {
        driver.findElement(colourBlack).click();
    }
    //метод выбирает черный цвет самоката
    public void clickColourGrey() {
        driver.findElement(colourGrey).click();
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
        driver.findElement(comment).sendKeys(commentText);
    }
    //нажать на кнопку "Заказать" внизу страницы
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
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
