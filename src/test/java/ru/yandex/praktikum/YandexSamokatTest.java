package ru.yandex.praktikum;

import WebPages.AboutRentOrderPage;
import WebPages.Modalka;
import WebPages.OrderPopupButtons;
import WebPages.PersonalInfoOrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class YandexSamokatTest {
    private WebDriver driver;

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
    public void scooterOrderTopButton() throws InterruptedException {
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        PersonalInfoOrderPage personalInfoOrderPage = new PersonalInfoOrderPage(driver);
        //нажать на кнопку куки
        personalInfoOrderPage.clickCookieButton();
        //кликнуть на верхнюю кнопку заказа самоката
        personalInfoOrderPage.clickOrderInHeaderButton();
        //ввести имя
        personalInfoOrderPage.inputUserName("Йура");
        //ввести фамилию
        personalInfoOrderPage.inputUserSurname("Рыбалочкин");
        //ввести адрес
        personalInfoOrderPage.inputUserAddress("Ленина1");
        //выбрать станцию метро и кликнуть на нее
        personalInfoOrderPage.clickAndChooseMetroStation();
        //ввести номер телефона
        personalInfoOrderPage.inputTelNumber("11111111111");
        //нажать Далее
        personalInfoOrderPage.clickOrderNextButton();
        //выполнен переход на страницу "Про аренду"
        AboutRentOrderPage aboutRentOrderPage = new AboutRentOrderPage(driver);
        //выбрать дату доставки самоката
        aboutRentOrderPage.selectDeliveryDate("01.01.2023");
        //рандомно выбрать срок аренды и нажать на него
        aboutRentOrderPage.chooseAndClickOrderPeriod();
        //нажать "Заказать"
        aboutRentOrderPage.clickOrderYesButton();
        //подтвердить заказ. Нажать кнопку Да
        OrderPopupButtons orderPopupButtons = new OrderPopupButtons(driver);
        orderPopupButtons.clickYesButton();
        Modalka modalka = new Modalka(driver);
        modalka.checkOrderStatus();
    }
}
