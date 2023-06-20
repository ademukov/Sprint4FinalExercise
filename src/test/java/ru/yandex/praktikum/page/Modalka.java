package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Modalka {
    private WebDriver driver;
    //модалка с номером заказа
    public By orderStatus = By.xpath("//div[text()='Заказ оформлен']");

    public Modalka(WebDriver driver) {
        this.driver = driver;
    }
}
