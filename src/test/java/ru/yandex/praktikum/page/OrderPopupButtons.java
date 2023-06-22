package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrderPopupButtons {

    private WebDriver driver;
    //кнопка Нет
    public By buttonNo = By.xpath("//button[text()='Нет']");
    //кнопка Да
    public By buttonYes = By.xpath("//button[text()='Да']");

    public OrderPopupButtons(WebDriver driver) {
        this.driver = driver;
    }
}
//выбрать вопрос из списка вопросов и нажать на стрелку
//проверить соответствие текста ответа на выбранный вопрос шаблону