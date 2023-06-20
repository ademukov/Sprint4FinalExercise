package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrderPopupButtons {

    private WebDriver driver;
    //кнопка Нет
    public By buttonNo = By.xpath("/html/body/div[1]/div/div[2]/div[5]/div[2]/button[1]");
    //кнопка Да
    public By buttonYes = By.xpath("//button[text()='Да']");

    public OrderPopupButtons(WebDriver driver) {
        this.driver = driver;
    }
}
//выбрать вопрос из списка вопросов и нажать на стрелку
//проверить соответствие текста ответа на выбранный вопрос шаблону