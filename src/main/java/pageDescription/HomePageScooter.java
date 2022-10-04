package pageDescription;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

// Класс главной страницы
public class HomePageScooter {
    private WebDriver driver;
    //Локатор для кнопки "Заказать" в шапке страницы
    private final By buttonMakeOrderInHead = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    //Локатор для кнопки "Заказать" внизу страницы
    private final By buttonMakeOrderInTheEnd = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    //Локатор для логотипа "Самокат" в шапке
    private final By scooter = By.xpath(".//img[@alt = 'Scooter']");
    //Локатор для логотипа "Яндекс" в шапке
    private final By yandex = By.xpath(".//img[@alt = 'Yandex']");
    //Локатор для вопроса: Сколько это стоит? (Раздел: Вопросы о важном)
    private final By questionPrice = By.id("accordion__heading-0");
    //Локатор для ответа: Сколько это стоит? (Раздел: Вопросы о важном)
    private final By answerPrice = By.id("accordion__panel-0");
    //Эталонный текст для вопроса: Сколько это стоит?
    private final String textPrice = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    //Локатор для вопроса: Хочу сразу несколько самокатов!  (Раздел: Вопросы о важном)
    private final By questionRentSeveralScooters = By.id("accordion__heading-1");
    //Локатор для ответа: Хочу сразу несколько самокатов!  (Раздел: Вопросы о важном)
    private final By answerRentSeveralScooters = By.id("accordion__panel-1");
    //Эталонный текст для вопроса: Хочу сразу несколько самокатов!
    private final String textRentSeveralScooters = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    //Локатор для вопроса: Как рассчитывается время аренды? (Раздел: Вопросы о важном)
    private final By questionRentalTime = By.id("accordion__heading-2");
    //Локатор для ответа: Как рассчитывается время аренды? (Раздел: Вопросы о важном)
    private final By answerRentalTime = By.id("accordion__panel-2");
    //Эталонный текст для вопроса: Как рассчитывается время аренды?
    private final String textRentalTime = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    //Локатор для вопроса: Можно ли заказать самокат прямо на сегодня? (Раздел: Вопросы о важном)
    private final By questionUrgentOrder = By.id("accordion__heading-3");
    //Локатор для ответа: Можно ли заказать самокат прямо на сегодня? (Раздел: Вопросы о важном)
    private final By answerUrgentOrder = By.id("accordion__panel-3");
    //Эталонный текст для вопроса: Можно ли заказать самокат прямо на сегодня?
    private final String textUrgentOrder = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    //Локатор для вопроса: Можно ли продлить заказ или вернуть самокат раньше? (Раздел: Вопросы о важном)
    private final By questionExtendOrder = By.id("accordion__heading-4");
    //Локатор для ответа: Можно ли продлить заказ или вернуть самокат раньше? (Раздел: Вопросы о важном)
    private final By answerExtendOrder = By.id("accordion__panel-4");
    //Эталонный текст для вопроса: Можно ли продлить заказ или вернуть самокат раньше?
    private final String textExtendOrder = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    //Локатор для вопроса: Вы привозите зарядку вместе с самокатом? (Раздел: Вопросы о важном)
    private final By questionAvailabilityCharging = By.id("accordion__heading-5");
    //Локатор для ответа: Вы привозите зарядку вместе с самокатом? (Раздел: Вопросы о важном)
    private final By answerAvailabilityCharging = By.id("accordion__panel-5");
    //Эталонный текст для вопроса: Вы привозите зарядку вместе с самокатом?
    private final String textAvailabilityCharging = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    //Локатор для вопроса: Можно ли отменить заказ? (Раздел: Вопросы о важном)
    private final By questionCancelOrder = By.id("accordion__heading-6");
    //Локатор для ответа: Можно ли отменить заказ? (Раздел: Вопросы о важном)
    private final By answerCancelOrder = By.id("accordion__panel-6");
    //Эталонный текст для вопроса: Можно ли отменить заказ?
    private final String textCancelOrder = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    //Локатор для вопроса: Я жизу за МКАДом, привезёте? (Раздел: Вопросы о важном)
    private final By questionAvailableDistance = By.id("accordion__heading-7");
    //Локатор для ответа: Я жизу за МКАДом, привезёте? (Раздел: Вопросы о важном)
    private final By answerAvailableDistance = By.id("accordion__panel-7");
    //Эталонный текст для вопроса: Я жизу за МКАДом, привезёте?
    private final String textAvailableDistance = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";




    //Конструктор
    public HomePageScooter(WebDriver driver){
        this.driver = driver;
    }



    //Нажать на кнопку "Заказать" в шапке страницы
    public void clickButtonOrderInHead() {
        driver.findElement(buttonMakeOrderInHead).click();
    }

    //Нажать на кнопку "Заказать" внизу страницы
    public void clickButtonOrderInTheEnd() {
        driver.findElement(buttonMakeOrderInTheEnd).click();
    }

    //Нажать на логотип "Самокат" в шапке страницы
    public void clickLogoScooter() {
        driver.findElement(scooter).click();
    }
    //Нажать на логотип "Яндекс" в шапке страницы
    public void clickLogoYandex() {
        driver.findElement(yandex).click();
    }

    //Нажать на вопрос: Сколько это стоит?
    public void clickQuestionPrice() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionPrice));
        driver.findElement(questionPrice).click();
    }
    //Метод проверяет правильность ответа на вопрос: Сколько это стоит?
    public void checkQuestionTextForPrice() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(answerPrice)));
        assertEquals("Текст ответа не совпадает", textPrice, driver.findElement(answerPrice).getText());
    }
    //Нажать на вопрос: Хочу сразу несколько самокатов!
    public void clickQuestionSeveralScooters() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionRentSeveralScooters));
        driver.findElement(questionRentSeveralScooters).click();
    }
    //Метод проверяет правильность ответа на вопрос: Хочу сразу несколько самокатов!
    public void checkQuestionTextForSeveralScooters() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(answerRentSeveralScooters)));
        assertEquals("Текст ответа не совпадает", textRentSeveralScooters, driver.findElement(answerRentSeveralScooters).getText());
    }
    //Нажать на вопрос: Как рассчитывается время аренды?
    public void clickQuestionRentalTime() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionRentalTime));
        driver.findElement(questionRentalTime).click();
    }
    //Метод проверяет правильность ответа на вопрос: Как рассчитывается время аренды?
    public void checkQuestionTextForRentalTime() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(answerRentalTime)));
        assertEquals("Текст ответа не совпадает", textRentalTime, driver.findElement(answerRentalTime).getText());
    }
    //Нажать на вопрос: Можно ли заказать самокат прямо на сегодня?
    public void clickQuestionUrgentOrder() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionUrgentOrder));
        driver.findElement(questionUrgentOrder).click();
    }
    //Метод проверяет правильность ответа на вопрос: Можно ли заказать самокат прямо на сегодня?
    public void checkQuestionTextForUrgentOrder() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(answerUrgentOrder)));
        assertEquals("Текст ответа не совпадает", textUrgentOrder, driver.findElement(answerUrgentOrder).getText());
    }
    //Нажать на вопрос: Можно ли продлить заказ или вернуть самокат раньше?
    public void clickQuestionExtendOrder() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionExtendOrder));
        driver.findElement(questionExtendOrder).click();
    }
    //Метод проверяет правильность ответа  на вопрос: Можно ли продлить заказ или вернуть самокат раньше?
    public void checkQuestionTextForExtendOrder() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(answerExtendOrder
)));
        assertEquals("Текст ответа не совпадает", textExtendOrder, driver.findElement(answerExtendOrder
).getText());
    }
    //Нажать на вопрос: Вы привозите зарядку вместе с самокатом?
    public void clickQuestionAvailabilityCharging() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionAvailabilityCharging));
        driver.findElement(questionAvailabilityCharging).click();
    }
    //Метод проверяет правильность ответа на вопрос: Вы привозите зарядку вместе с самокатом?
    public void checkQuestionTextForAvailabilityCharging() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(answerAvailabilityCharging)));
        assertEquals("Текст ответа не совпадает", textAvailabilityCharging, driver.findElement(answerAvailabilityCharging).getText());
    }
    //Нажать на вопрос: Можно ли отменить заказ?
    public void clickQuestionCancelOrder() {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionCancelOrder));
        driver.findElement(questionCancelOrder).click();
    }
    //Метод проверяет правильность ответа на вопрос: Можно ли отменить заказ?
    public void checkQuestionTextForCancelOrder() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(answerCancelOrder)));
        assertEquals("Текст ответа не совпадает", textCancelOrder, driver.findElement(answerCancelOrder).getText());
    }
    //Нажать на вопрос: Я жизу за МКАДом, привезёте?
    public void clickQuestionAvailableDistance() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionAvailableDistance));
        driver.findElement(questionAvailableDistance).click();
    }
    //Метод проверяет правильность ответа на вопрос: Я жизу за МКАДом, привезёте?
    public void checkQuestionTextForAvailableDistance() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(answerAvailableDistance)));
        assertEquals("Текст ответа не совпадает", textAvailableDistance, driver.findElement(answerAvailableDistance).getText());
    }

}
