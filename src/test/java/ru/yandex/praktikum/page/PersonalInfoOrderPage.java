package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;


public class PersonalInfoOrderPage {
    private WebDriver driver;

    //Кнопка "Заказать" в header
    public By orderInHeader = By.xpath("//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //Кнопка "Заказать" внизу страницы
    public By orderDownBelow = By.xpath("//button[class='Button_Button__ra12g Button_Middle__1CSJM']");
    //поле имя
    public By name = By.xpath("//input[@placeholder='* Имя']");
    //поле фамилия
    public By surname = By.xpath("//input[@placeholder='* Фамилия']");
    //поле адрес
    public By address = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //поле метро
    public By metro = By.cssSelector(".select-search__input");
    //список станций метро
    public By metroStations = By.cssSelector("li.select-search__row button");
 //   @FindBy
 //           (css = ".select-search__input")
 //   public List <WebElement> Metro;
    //поле номер телефона
    public By phoneNumber = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //кнопка Далее
    public By nextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //кнопка Cookie
    public By cookieButton = By.id("rcc-confirm-button");

    public PersonalInfoOrderPage(WebDriver driver) {
        this.driver = driver;
    }
//    public void getRandomMetroStations() {
//        Random random = new Random();
//        driver.findElement(metro).click();
//        List<WebElement> metroStationsList = driver.findElements(metroStations);
//        metroStationsList.get(random.nextInt(metroStationsList.size())).click();
//    }
}
