package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;


public class PersonalInfoOrderPage {
    //Кнопка "Заказать" в header
    private By orderInHeaderButton = By.xpath("//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //Кнопка "Заказать" внизу страницы
    private By orderDownBelowButton = By.xpath("//button[class='Button_Button__ra12g Button_Middle__1CSJM']");
    //поле имя
    private By name = By.xpath("//input[@placeholder='* Имя']");
    //поле фамилия
    private By surname = By.xpath("//input[@placeholder='* Фамилия']");
    //поле адрес
    private By address = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //поле метро
    private By metro = By.cssSelector(".select-search__input");
    //список станций метро
    private By metroStations = By.cssSelector("li.select-search__row button");
    //поле номер телефона
    private By phoneNumber = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //кнопка Далее
    private By nextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //кнопка Cookie
    private By cookieButton = By.id("rcc-confirm-button");
    private WebDriver driver;

    //добавить метод с заполнением полей Имя, Фамилия, адрес, метро, номер телефона, заказа самоката
    public PersonalInfoOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //дождаться появления кнопки подтверждения куки и кликнуть на нее
    public void clickCookieButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(driver.findElement(cookieButton)));
        driver.findElement(cookieButton).click();
    }

    //клик по кнопке Заказать в хедере
    public void clickOrderInHeaderButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderInHeaderButton)));
        driver.findElement(orderInHeaderButton).click();
    }

    //ввод имени пользователя в строку Имя
    public void inputUserName(String username) {
        driver.findElement(name).sendKeys(username);
    }

    //ввод фамилии пользователя в строку фамилия
    public void inputUserSurname(String userSurname) {
        driver.findElement(surname).sendKeys(userSurname);
    }

    //ввод адреса пользователя в строку адрес
    public void inputUserAddress(String userAddress) {
        driver.findElement(address).sendKeys(userAddress);
    }

    //рандомный выбор станции метро
    public void clickAndChooseMetroStation() {
        //кликнуть в поле Метро
        driver.findElement(metro).click();
        //рандомно выбрать станцию
        List<WebElement> metroStationsRandom = driver.findElements(metroStations);
        WebElement randomMetroStation = metroStationsRandom.get(new Random().nextInt(metroStationsRandom.size()));
        // Кликнуть на выбранной станции метро
        randomMetroStation.click();
    }

    //ввод телефона в строку ввода телефона
    public void inputTelNumber(String telNumber) {
        driver.findElement(phoneNumber).sendKeys(telNumber);
    }

    //клик на кнопку Далее
    public void clickOrderNextButton() {
        driver.findElement(nextButton).click();
    }
}
