package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;



    //кнопка Подтверждения куков
//    public By cookieButtonAccept = By.cssSelector("App_CookieButton__3cvqF");

    //Выпадающий список в разделе "Вопросы о важном". Когда нажимаешь на стрелочку, открывается соответствующий текст
  //  public By questions = By.xpath("//div[@data-accordion-component='AccordionItem']/div/div/text()"); //или такой селектор div[data-accordion-component = 'AccordionItem']

    //вопрос 1 "Сколько это стоит? И как оплатить?"
    public By question1 = By.xpath("//div[@id='accordion__heading-0']");
    public By answer1 = By.xpath("//div/div[@id='accordion__panel-0']");

    //вопрос 2 "Хочу сразу несколько самокатов! Так можно?"
    public By question2 = By.xpath("//*[@id='accordion__heading-1']");
    public By answer2 = By.xpath("//div/div[@id='accordion__panel-1']");

    //вопрос 3 "Как рассчитывается время аренды?"
    public By question3 = By.id("accordion__heading-2");
    public By answer3 = By.xpath("//div/div[@id='accordion__panel-2']");

    //вопрос 4 "Можно ли заказать самокат прямо на сегодня?"
    public By question4 = By.xpath("//*[@id='accordion__heading-3']");
    public By answer4 = By.xpath("//div/div[@id='accordion__panel-3']");

    //вопрос 5 "Можно ли продлить заказ или вернуть самокат раньше?"
    public By question5 = By.xpath("//*[@id='accordion__heading-4']");
    public By answer5 = By.xpath("//div/div[@id='accordion__panel-4']");

    //вопрос 6 "Вы привозите зарядку вместе с самокатом?"
    public By question6 = By.xpath("//*[@id='accordion__heading-5']");
    public By answer6 = By.xpath("//div/div[@id='accordion__panel-5']");

    //вопрос 7 "Можно ли отменить заказ?"
    public By question7 = By.xpath("//*[@id='accordion__heading-6']");
    public By answer7 = By.xpath("//div/div[@id='accordion__panel-6']");

    //вопрос 8 "Я жизу за МКАДом, привезёте?"
    public By question8 = By.xpath("//*[@id='accordion__heading-7']");
    public By answer8 = By.xpath("//div/div[@id='accordion__panel-7']");



    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


}
