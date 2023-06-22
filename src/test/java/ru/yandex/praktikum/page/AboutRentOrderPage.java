package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutRentOrderPage {
    private WebDriver driver;
    //поле дата. Выбор из календаря
    public By fieldDate = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //поле срок аренды. Выпадающий список
    public By fieldRentalPeriod = By.xpath("//div[@class='Dropdown-placeholder']");
    public By rentalPeriodList = By.xpath("//div[@class='Dropdown-option' and text()='сутки']");
    //поле цвет самоката. Чекбоксы
    public By checkBoxColorBlack = By.xpath("//label[@for='black']");
    public By checkBoxColorGray = By.xpath("//label[@for='gray']");
    //поле Комментарий для курьера
    public By fieldComment = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //кнопка Назад
    public By buttonBack = By.xpath("//button[text()='Назад']");
    //кнопка Заказать
    public By buttonOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public AboutRentOrderPage(WebDriver driver) {
        this.driver = driver;
    }
}
