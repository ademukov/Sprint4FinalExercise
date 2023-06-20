package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.page.*;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class YandexSamokatTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        if ("Chrome".equals(System.getProperty("browsername"))) {
            setupChromeDriver();
        } else {
            setupFireFox();
        }
    }

    private void setupFireFox() {
        System.setProperty("webdriver.gecko.driver", "/Users/ademukov/Downloads/firefox_driver/geckodriver_x32");
        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--headless");
        driver = new FirefoxDriver(options);
    }

    private void setupChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/ademukov/Downloads/chromedriver_mac64/chromedriver");
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox",
//                "--headless",
                "--disable-dev-shm-usage",
                "start-maximized");
        driver = new ChromeDriver(options);
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }

    @Test
    public void checkDropDownText() {
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        wait = new WebDriverWait(driver, 10);
        //ищем первый вопрос и кликаем на него и сверяем шаблон ответа
        WebElement question1 = driver.findElement(mainPage.question1);
        WebElement answer1 = driver.findElement(mainPage.answer1);
        //используем JavascriptExecutor для скроллинга до первого элемента
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", question1);
        question1.click();
        wait.until(ExpectedConditions.visibilityOf(answer1));
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                answer1.getText());
        //ищем второй вопрос и кликаем на него и сверяем шаблон ответа
        driver.findElement(mainPage.question2).click();
        WebElement answer2 = driver.findElement(mainPage.answer2);
        wait.until(ExpectedConditions.visibilityOf(answer2));
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                answer2.getText());
        //ищем третий вопрос и кликаем на него и сверяем шаблон ответа
        driver.findElement(mainPage.question3).click();
        WebElement answer3 = driver.findElement(mainPage.answer3);
        wait.until(ExpectedConditions.visibilityOf(answer3));
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                answer3.getText());
        //ищем четвертый вопрос и кликаем на него и сверяем шаблон ответа
        driver.findElement(mainPage.question4).click();
        WebElement answer4 = driver.findElement(mainPage.answer4);
        wait.until(ExpectedConditions.visibilityOf(answer4));
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                answer4.getText());
        //ищем пятый вопрос и кликаем на него и сверяем шаблон ответа
        driver.findElement(mainPage.question5).click();
        WebElement answer5 = driver.findElement(mainPage.answer5);
        wait.until(ExpectedConditions.visibilityOf(answer5));
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                answer5.getText());
        //ищем шестой вопрос и кликаем на него и сверяем шаблон ответа
        driver.findElement(mainPage.question6).click();
        WebElement answer6 = driver.findElement(mainPage.answer6);
        wait.until(ExpectedConditions.visibilityOf(answer6));
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                answer6.getText());
        //ищем седьмой вопрос и кликаем на него и сверяем шаблон ответа
        driver.findElement(mainPage.question7).click();
        WebElement answer7 = driver.findElement(mainPage.answer7);
        wait.until(ExpectedConditions.visibilityOf(answer7));
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                answer7.getText());
        //ищем восьмой вопрос и кликаем на него и сверяем шаблон ответа
        driver.findElement(mainPage.question8).click();
        WebElement answer8 = driver.findElement(mainPage.answer8);
        wait.until(ExpectedConditions.visibilityOf(answer8));
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                answer8.getText());

    }

    @Test
    public void scooterOrderTopButton() throws InterruptedException {
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        PersonalInfoOrderPage personalInfoOrderPage = new PersonalInfoOrderPage(driver);
        wait = new WebDriverWait(driver, 10);

        //дождаться появления кнопки подтверждения куки и кликнуть на нее
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(personalInfoOrderPage.cookieButton)));
        driver.findElement(personalInfoOrderPage.cookieButton).click();
        //кликнуть на верхнюю кнопку заказа самоката
        driver.findElement(personalInfoOrderPage.orderInHeader).click();
        WebElement name = driver.findElement(personalInfoOrderPage.name);
        wait.until(ExpectedConditions.visibilityOf(name));
        //ввести имя
        driver.findElement(personalInfoOrderPage.name).sendKeys("Йура");
        //ввести фамилию
        driver.findElement(personalInfoOrderPage.surname).sendKeys("Рыбалко");
        //ввести адрес
        driver.findElement(personalInfoOrderPage.address).sendKeys("Профсоюзная 1");
        //кликнуть в поле "Метро"
        driver.findElement(personalInfoOrderPage.metro).click();
        // Дождаться появления списка станций метро и выбрать случайную
        List<WebElement> metroStations = driver.findElements(personalInfoOrderPage.metroStations);
        WebElement randomMetroStation = metroStations.get(new Random().nextInt(metroStations.size()));
        // Кликнуть на выбранной станции метро
        randomMetroStation.click();
        //ввести номер телефона и кликнуть
        driver.findElement(personalInfoOrderPage.phoneNumber).sendKeys("11111111111");
        driver.findElement(personalInfoOrderPage.nextButton).click();
        //выполнен переход на страницу "Про аренду"
        AboutRentOrderPage aboutRentOrderPage = new AboutRentOrderPage(driver);
        // wait = new WebDriverWait(driver, 10);
        //выбрать дату доставки самоката
        driver.findElement(aboutRentOrderPage.fieldDate).click();
        //ввести дату
        driver.findElement(aboutRentOrderPage.fieldDate).sendKeys("01.01.2023", Keys.ENTER);

        //выбрать срок аренды (выпадающий список)
        driver.findElement(aboutRentOrderPage.fieldRentalPeriod).click();
        driver.findElement(aboutRentOrderPage.rentalPeriodList).click();
        //нажать "Заказать"
        driver.findElement(aboutRentOrderPage.buttonOrder).click();
        //подтвердить заказ. Нажать кнопку Да
        OrderPopupButtons orderPopupButtons = new OrderPopupButtons(driver);
        driver
                .findElement(orderPopupButtons.buttonYes)
                .click();
        Modalka modalka = new Modalka(driver);
        WebElement status = driver.findElement(modalka.orderStatus);
        wait.until(ExpectedConditions.visibilityOf(status));


    }
}
