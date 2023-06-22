package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.String.format;

public class MainPage {
    //темплейтирование
    private static final String QUESTION_TEMPLATE = "//*[@id='accordion__heading-%s']";
    private static final String ANSWER_TEMPLATE = "//div/div[@id='accordion__panel-%s']";
    private WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String answerOnQuestion(int index) {
        //производим декремент индекса, чтоб использовать его как компьютер, а не как человек
        index--;
        //ищем первый вопрос и кликаем на него и сверяем шаблон ответа
        WebElement elementQuestion = driver.findElement(
                By.xpath(format(QUESTION_TEMPLATE, index)));
        //используем JavascriptExecutor для скроллинга до первого элемента
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", elementQuestion);
        elementQuestion.click();
        return new WebDriverWait(driver, 10)
                .until(
                        ExpectedConditions
                                .visibilityOf(driver.findElement(
                                        By.xpath(format(ANSWER_TEMPLATE, index))))
                ).getText();
    }
}
