package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class AboutRentOrderPage {
    private WebDriver driver;
    //поле дата. Выбор из календаря
    private By fieldDate = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //поле срок аренды. Выпадающий список
    private By fieldRentalPeriod = By.xpath("//div[@class='Dropdown-placeholder']");
    //список срока бронирования
    private By rentalPeriodList = By.xpath("//div[@class='Dropdown-option']");
    //поле цвет самоката. Чекбоксы
    private By checkBoxColorBlack = By.xpath("//label[@for='black']");
    private By checkBoxColorGray = By.xpath("//label[@for='gray']");
    //поле Комментарий для курьера
    private By fieldComment = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //кнопка Назад
    private By buttonBack = By.xpath("//button[text()='Назад']");
    //кнопка Заказать
    private By buttonOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public AboutRentOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //выбор даты доставки самоката
    public void selectDeliveryDate(String deliveryDate) {
        driver.findElement(fieldDate).sendKeys(deliveryDate, Keys.ENTER);
    }

    //рандомный выбор срока аренды самоката
    public void chooseAndClickOrderPeriod() {
        driver.findElement(fieldRentalPeriod).click();
        List<WebElement> randomOrderPeriod = driver.findElements(rentalPeriodList);
        WebElement orderPeriodRandomClick = randomOrderPeriod.get(new Random().nextInt(randomOrderPeriod.size()));
        orderPeriodRandomClick.click();
    }

    //нажатие кнопки Заказать при подтверждении заказа
    public void clickOrderYesButton() {
        driver.findElement(buttonOrder).click();
    }
}
