package pageDescription;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

// Класс главной страницы
public class HomePageScooter {
    private final WebDriver DRIVER;
    //Локатор для кнопки "Заказать" в шапке страницы
    private final By BUTTON_MAKE_ORDER_IN_HEAD = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    //Локатор для кнопки "Заказать" внизу страницы
    private final By BUTTON_MAKE_ORDER_IN_THE_END = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    //Локатор для логотипа "Самокат" в шапке
    private final By SCOOTER = By.xpath(".//img[@alt = 'Scooter']");
    //Локатор для логотипа "Яндекс" в шапке
    private final By YANDEX = By.xpath(".//img[@alt = 'Yandex']");
    //Локатор для вопроса: Сколько это стоит? (Раздел: Вопросы о важном)
    private final By QUESTION_PRICE = By.id("accordion__heading-0");
    //Локатор для ответа: Сколько это стоит? (Раздел: Вопросы о важном)
    private final By ANSWER_PRICE = By.id("accordion__panel-0");
    //Эталонный текст для вопроса: Сколько это стоит?
    private final String TEXT_PRICE = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    //Локатор для вопроса: Хочу сразу несколько самокатов!  (Раздел: Вопросы о важном)
    private final By QUESTION_RENT_SEVERAL_SCOOTERS = By.id("accordion__heading-1");
    //Локатор для ответа: Хочу сразу несколько самокатов!  (Раздел: Вопросы о важном)
    private final By ANSWER_RENT_SEVERAL_SCOOTERS = By.id("accordion__panel-1");
    //Эталонный текст для вопроса: Хочу сразу несколько самокатов!
    private final String TEXT_RENT_SEVERAL_SCOOTERS = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    //Локатор для вопроса: Как рассчитывается время аренды? (Раздел: Вопросы о важном)
    private final By QUESTION_RENTAL_TIME = By.id("accordion__heading-2");
    //Локатор для ответа: Как рассчитывается время аренды? (Раздел: Вопросы о важном)
    private final By ANSWER_RENTAL_TIME = By.id("accordion__panel-2");
    //Эталонный текст для вопроса: Как рассчитывается время аренды?
    private final String TEXT_RENTAL_TIME = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    //Локатор для вопроса: Можно ли заказать самокат прямо на сегодня? (Раздел: Вопросы о важном)
    private final By QUESTION_URGENT_ORDER = By.id("accordion__heading-3");
    //Локатор для ответа: Можно ли заказать самокат прямо на сегодня? (Раздел: Вопросы о важном)
    private final By ANSWER_URGENT_ORDER = By.id("accordion__panel-3");
    //Эталонный текст для вопроса: Можно ли заказать самокат прямо на сегодня?
    private final String TEXT_URGENT_ORDER = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    //Локатор для вопроса: Можно ли продлить заказ или вернуть самокат раньше? (Раздел: Вопросы о важном)
    private final By QUESTION_EXTEND_ORDER = By.id("accordion__heading-4");
    //Локатор для ответа: Можно ли продлить заказ или вернуть самокат раньше? (Раздел: Вопросы о важном)
    private final By ANSWER_EXTEND_ORDER = By.id("accordion__panel-4");
    //Эталонный текст для вопроса: Можно ли продлить заказ или вернуть самокат раньше?
    private final String TEXT_EXTEND_ORDER = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    //Локатор для вопроса: Вы привозите зарядку вместе с самокатом? (Раздел: Вопросы о важном)
    private final By QUESTION_AVAILABILITY_CHARGING = By.id("accordion__heading-5");
    //Локатор для ответа: Вы привозите зарядку вместе с самокатом? (Раздел: Вопросы о важном)
    private final By ANSWER_AVAILABILITY_CHARGING = By.id("accordion__panel-5");
    //Эталонный текст для вопроса: Вы привозите зарядку вместе с самокатом?
    private final String TEXT_AVAILABILITY_CHARGING = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    //Локатор для вопроса: Можно ли отменить заказ? (Раздел: Вопросы о важном)
    private final By QUESTION_CANCEL_ORDER = By.id("accordion__heading-6");
    //Локатор для ответа: Можно ли отменить заказ? (Раздел: Вопросы о важном)
    private final By ANSWER_CANCEL_ORDER = By.id("accordion__panel-6");
    //Эталонный текст для вопроса: Можно ли отменить заказ?
    private final String TEXT_CANCEL_ORDER = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    //Локатор для вопроса: Я жизу за МКАДом, привезёте? (Раздел: Вопросы о важном)
    private final By QUESTION_AVAILABLE_DISTANCE = By.id("accordion__heading-7");
    //Локатор для ответа: Я жизу за МКАДом, привезёте? (Раздел: Вопросы о важном)
    private final By ANSWER_AVAILABLE_DISTANCE = By.id("accordion__panel-7");
    //Эталонный текст для вопроса: Я жизу за МКАДом, привезёте?
    private final String TEXT_AVAILABLE_DISTANCE = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";




    //Конструктор
    public HomePageScooter(WebDriver driver){
        this.DRIVER = driver;
    }



    //Нажать на кнопку "Заказать" в шапке страницы
    public void clickButtonOrderInHead() {
        DRIVER.findElement(BUTTON_MAKE_ORDER_IN_HEAD).click();
    }

    //Нажать на кнопку "Заказать" внизу страницы
    public void clickButtonOrderInTheEnd() {
        DRIVER.findElement(BUTTON_MAKE_ORDER_IN_THE_END).click();
    }

    //Нажать на логотип "Самокат" в шапке страницы
    public void clickLogoScooter() {
        DRIVER.findElement(SCOOTER).click();
    }
    //Нажать на логотип "Яндекс" в шапке страницы
    public void clickLogoYandex() {
        DRIVER.findElement(YANDEX).click();
    }

    //Нажать на вопрос: Сколько это стоит?
    public void clickQuestionPrice() {
        ((JavascriptExecutor) DRIVER).executeScript("arguments[0].scrollIntoView();", DRIVER.findElement(QUESTION_PRICE));
        DRIVER.findElement(QUESTION_PRICE).click();
    }
    //Метод проверяет правильность ответа на вопрос: Сколько это стоит?
    public void checkQuestionTextForPrice() {
        new WebDriverWait(DRIVER, 10).until(ExpectedConditions.elementToBeClickable(DRIVER.findElement(ANSWER_PRICE)));
        assertEquals("Текст ответа не совпадает", TEXT_PRICE, DRIVER.findElement(ANSWER_PRICE).getText());
    }
    //Нажать на вопрос: Хочу сразу несколько самокатов!
    public void clickQuestionSeveralScooters() {
        ((JavascriptExecutor) DRIVER).executeScript("arguments[0].scrollIntoView();", DRIVER.findElement(QUESTION_RENT_SEVERAL_SCOOTERS));
        DRIVER.findElement(QUESTION_RENT_SEVERAL_SCOOTERS).click();
    }
    //Метод проверяет правильность ответа на вопрос: Хочу сразу несколько самокатов!
    public void checkQuestionTextForSeveralScooters() {
        new WebDriverWait(DRIVER, 10).until(ExpectedConditions.elementToBeClickable(DRIVER.findElement(ANSWER_RENT_SEVERAL_SCOOTERS)));
        assertEquals("Текст ответа не совпадает", TEXT_RENT_SEVERAL_SCOOTERS, DRIVER.findElement(ANSWER_RENT_SEVERAL_SCOOTERS).getText());
    }
    //Нажать на вопрос: Как рассчитывается время аренды?
    public void clickQuestionRentalTime() {
        ((JavascriptExecutor) DRIVER).executeScript("arguments[0].scrollIntoView();", DRIVER.findElement(QUESTION_RENTAL_TIME));
        DRIVER.findElement(QUESTION_RENTAL_TIME).click();
    }
    //Метод проверяет правильность ответа на вопрос: Как рассчитывается время аренды?
    public void checkQuestionTextForRentalTime() {
        new WebDriverWait(DRIVER, 10).until(ExpectedConditions.elementToBeClickable(DRIVER.findElement(ANSWER_RENTAL_TIME)));
        assertEquals("Текст ответа не совпадает", TEXT_RENTAL_TIME, DRIVER.findElement(ANSWER_RENTAL_TIME).getText());
    }
    //Нажать на вопрос: Можно ли заказать самокат прямо на сегодня?
    public void clickQuestionUrgentOrder() {
        ((JavascriptExecutor) DRIVER).executeScript("arguments[0].scrollIntoView();", DRIVER.findElement(QUESTION_URGENT_ORDER));
        DRIVER.findElement(QUESTION_URGENT_ORDER).click();
    }
    //Метод проверяет правильность ответа на вопрос: Можно ли заказать самокат прямо на сегодня?
    public void checkQuestionTextForUrgentOrder() {
        new WebDriverWait(DRIVER, 10).until(ExpectedConditions.elementToBeClickable(DRIVER.findElement(ANSWER_URGENT_ORDER)));
        assertEquals("Текст ответа не совпадает", TEXT_URGENT_ORDER, DRIVER.findElement(ANSWER_URGENT_ORDER).getText());
    }
    //Нажать на вопрос: Можно ли продлить заказ или вернуть самокат раньше?
    public void clickQuestionExtendOrder() {
        ((JavascriptExecutor) DRIVER).executeScript("arguments[0].scrollIntoView();", DRIVER.findElement(QUESTION_EXTEND_ORDER));
        DRIVER.findElement(QUESTION_EXTEND_ORDER).click();
    }
    //Метод проверяет правильность ответа  на вопрос: Можно ли продлить заказ или вернуть самокат раньше?
    public void checkQuestionTextForExtendOrder() {
        new WebDriverWait(DRIVER, 10).until(ExpectedConditions.elementToBeClickable(DRIVER.findElement(ANSWER_EXTEND_ORDER
)));
        assertEquals("Текст ответа не совпадает", TEXT_EXTEND_ORDER, DRIVER.findElement(ANSWER_EXTEND_ORDER
).getText());
    }
    //Нажать на вопрос: Вы привозите зарядку вместе с самокатом?
    public void clickQuestionAvailabilityCharging() {
        ((JavascriptExecutor) DRIVER).executeScript("arguments[0].scrollIntoView();", DRIVER.findElement(QUESTION_AVAILABILITY_CHARGING));
        DRIVER.findElement(QUESTION_AVAILABILITY_CHARGING).click();
    }
    //Метод проверяет правильность ответа на вопрос: Вы привозите зарядку вместе с самокатом?
    public void checkQuestionTextForAvailabilityCharging() {
        new WebDriverWait(DRIVER, 10).until(ExpectedConditions.elementToBeClickable(DRIVER.findElement(ANSWER_AVAILABILITY_CHARGING)));
        assertEquals("Текст ответа не совпадает", TEXT_AVAILABILITY_CHARGING, DRIVER.findElement(ANSWER_AVAILABILITY_CHARGING).getText());
    }
    //Нажать на вопрос: Можно ли отменить заказ?
    public void clickQuestionCancelOrder() {

        ((JavascriptExecutor) DRIVER).executeScript("arguments[0].scrollIntoView();", DRIVER.findElement(QUESTION_CANCEL_ORDER));
        DRIVER.findElement(QUESTION_CANCEL_ORDER).click();
    }
    //Метод проверяет правильность ответа на вопрос: Можно ли отменить заказ?
    public void checkQuestionTextForCancelOrder() {
        new WebDriverWait(DRIVER, 10).until(ExpectedConditions.elementToBeClickable(DRIVER.findElement(ANSWER_CANCEL_ORDER)));
        assertEquals("Текст ответа не совпадает", TEXT_CANCEL_ORDER, DRIVER.findElement(ANSWER_CANCEL_ORDER).getText());
    }
    //Нажать на вопрос: Я жизу за МКАДом, привезёте?
    public void clickQuestionAvailableDistance() {
        ((JavascriptExecutor) DRIVER).executeScript("arguments[0].scrollIntoView();", DRIVER.findElement(QUESTION_AVAILABLE_DISTANCE));
        DRIVER.findElement(QUESTION_AVAILABLE_DISTANCE).click();
    }
    //Метод проверяет правильность ответа на вопрос: Я жизу за МКАДом, привезёте?
    public void checkQuestionTextForAvailableDistance() {
        new WebDriverWait(DRIVER, 10).until(ExpectedConditions.elementToBeClickable(DRIVER.findElement(ANSWER_AVAILABLE_DISTANCE)));
        assertEquals("Текст ответа не совпадает", TEXT_AVAILABLE_DISTANCE, DRIVER.findElement(ANSWER_AVAILABLE_DISTANCE).getText());
    }

}
