package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
        driver.close();
    }

    @Test
    public void checkDropDownText() {
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        wait = new WebDriverWait(driver, 10);
        //ищем первый вопрос и кликаем на него и сверяем шаблон ответа
        String answerOnQuestion1 = mainPage.answerOnFirstQuestion();
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                answerOnQuestion1);
        //ищем второй вопрос и кликаем на него и сверяем шаблон ответа
        String answerOnQuestion2 = mainPage.answerOnSecondQuestion();
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                answerOnQuestion2);
        //ищем третий вопрос и кликаем на него и сверяем шаблон ответа
        String answerOnQuestion3 = mainPage.answerOnThirdQuestion();
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                answerOnQuestion3);
        //ищем четвертый вопрос и кликаем на него и сверяем шаблон ответа
        String answerOnQuestion4 = mainPage.answerOnFourthQuestion();
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                answerOnQuestion4);
        //ищем пятый вопрос и кликаем на него и сверяем шаблон ответа
        String answerOnQuestion5 = mainPage.answerOnFifthQuestion();
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                answerOnQuestion5);
        //ищем шестой вопрос и кликаем на него и сверяем шаблон ответа
        String answerOnQuestion6 = mainPage.answerOnSixthQuestion();
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                answerOnQuestion6);
        //ищем седьмой вопрос и кликаем на него и сверяем шаблон ответа
        String answerOnQuestion7 = mainPage.answerOnSeventhQuestion();
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                answerOnQuestion7);
        //ищем восьмой вопрос и кликаем на него и сверяем шаблон ответа
        String answerOnQuestion8 = mainPage.answerOnEighthQuestion();
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                answerOnQuestion8);

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
