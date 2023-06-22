package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;


    //вопрос 1 "Сколько это стоит? И как оплатить?"
    private By question1 = By.xpath("//div[@id='accordion__heading-0']");
    private By answer1 = By.xpath("//div/div[@id='accordion__panel-0']");

    //вопрос 2 "Хочу сразу несколько самокатов! Так можно?"
    private By question2 = By.xpath("//*[@id='accordion__heading-1']");
    private By answer2 = By.xpath("//div/div[@id='accordion__panel-1']");

    //вопрос 3 "Как рассчитывается время аренды?"
    private By question3 = By.id("accordion__heading-2");
    private By answer3 = By.xpath("//div/div[@id='accordion__panel-2']");

    //вопрос 4 "Можно ли заказать самокат прямо на сегодня?"
    private By question4 = By.xpath("//*[@id='accordion__heading-3']");
    private By answer4 = By.xpath("//div/div[@id='accordion__panel-3']");

    //вопрос 5 "Можно ли продлить заказ или вернуть самокат раньше?"
    private By question5 = By.xpath("//*[@id='accordion__heading-4']");
    private By answer5 = By.xpath("//div/div[@id='accordion__panel-4']");

    //вопрос 6 "Вы привозите зарядку вместе с самокатом?"
    private By question6 = By.xpath("//*[@id='accordion__heading-5']");
    private By answer6 = By.xpath("//div/div[@id='accordion__panel-5']");

    //вопрос 7 "Можно ли отменить заказ?"
    private By question7 = By.xpath("//*[@id='accordion__heading-6']");
    private By answer7 = By.xpath("//div/div[@id='accordion__panel-6']");

    //вопрос 8 "Я жизу за МКАДом, привезёте?"
    private By question8 = By.xpath("//*[@id='accordion__heading-7']");
    private By answer8 = By.xpath("//div/div[@id='accordion__panel-7']");



    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //метод для получения текста первого вопроса
    public String answerOnFirstQuestion() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //ищем первый вопрос и кликаем на него и сверяем шаблон ответа
        WebElement elementQuestion1 = driver.findElement(question1);
        WebElement elementAnswer1 = driver.findElement(answer1);
        //используем JavascriptExecutor для скроллинга до первого элемента
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementQuestion1);
        elementQuestion1.click();
        return wait.until(ExpectedConditions.visibilityOf(elementAnswer1)).getText();
    }
    //метод для получения текста второго вопроса
    public String answerOnSecondQuestion() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //ищем второй вопрос и кликаем на него
        WebElement elementQuestion2 = driver.findElement(question2);
        WebElement elementAnswer2 = driver.findElement(answer2);
        elementQuestion2.click();
        return wait.until(ExpectedConditions.visibilityOf(elementAnswer2)).getText();
    }
    //метод для получения текста третьего вопроса
    public String answerOnThirdQuestion() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elementQuestion3 = driver.findElement(question3);
        WebElement elementAnswer3 = driver.findElement(answer3);
        elementQuestion3.click();
        return wait.until(ExpectedConditions.visibilityOf(elementAnswer3)).getText();
    }
    //метод для получения текста четвертого вопроса
    public String answerOnFourthQuestion() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elementQuestion4 = driver.findElement(question4);
        WebElement elementAnswer4 = driver.findElement(answer4);
        elementQuestion4.click();
        return wait.until(ExpectedConditions.visibilityOf(elementAnswer4)).getText();
    }
    //метод для получения текста пятого вопроса
    public String answerOnFifthQuestion() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elementQuestion5 = driver.findElement(question5);
        WebElement elementAnswer5 = driver.findElement(answer5);
        elementQuestion5.click();
        return wait.until(ExpectedConditions.visibilityOf(elementAnswer5)).getText();
    }
    //метод для получения текста шестого вопроса
    public String answerOnSixthQuestion() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elementQuestion6 = driver.findElement(question6);
        WebElement elementAnswer6 = driver.findElement(answer6);
        elementQuestion6.click();
        return wait.until(ExpectedConditions.visibilityOf(elementAnswer6)).getText();
    }
    //метод для получения текста седьмого вопроса
    public String answerOnSeventhQuestion() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elementQuestion7 = driver.findElement(question7);
        WebElement elementAnswer7 = driver.findElement(answer7);
        elementQuestion7.click();
        return wait.until(ExpectedConditions.visibilityOf(elementAnswer7)).getText();
    }
    //метод для получения текста восьмого вопроса
    public String answerOnEighthQuestion() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elementQuestion8 = driver.findElement(question8);
        WebElement elementAnswer8 = driver.findElement(answer8);
        elementQuestion8.click();
        return wait.until(ExpectedConditions.visibilityOf(elementAnswer8)).getText();
    }
}
