package ru.yandex.praktikum;

import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.yandex.praktikum.page.*;

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
    public void checkDropDownText() {
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        //добавляем softAssertions для того, чтобы тест проходил до конца и не падал при нахождении ошибки
        SoftAssertions softAssertions = new SoftAssertions();
        //ищем первый вопрос и кликаем на него и сверяем шаблон ответа
        softAssertions.assertThat("Сутки — 400 рублей. Оплата курьеру — наличными или картой.")
                .isEqualTo(mainPage.answerOnQuestion(1));
        //ищем второй вопрос и кликаем на него и сверяем шаблон ответа
        softAssertions.assertThat("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.")
                .isEqualTo(mainPage.answerOnQuestion(2));
        //ищем третий вопрос и кликаем на него и сверяем шаблон ответа
        softAssertions.assertThat("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.")
                .isEqualTo(mainPage.answerOnQuestion(3));
        //ищем четвертый вопрос и кликаем на него и сверяем шаблон ответа
        softAssertions.assertThat("Только начиная с завтрашнего дня. Но скоро станем расторопнее.")
                .isEqualTo(mainPage.answerOnQuestion(4));
        //ищем пятый вопрос и кликаем на него и сверяем шаблон ответа
        softAssertions.assertThat("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.")
                .isEqualTo(mainPage.answerOnQuestion(5));
        //ищем шестой вопрос и кликаем на него и сверяем шаблон ответа
        softAssertions.assertThat("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.")
                .isEqualTo(mainPage.answerOnQuestion(6));
        //ищем седьмой вопрос и кликаем на него и сверяем шаблон ответа
        softAssertions.assertThat("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.")
                .isEqualTo(mainPage.answerOnQuestion(7));
        //ищем восьмой вопрос и кликаем на него и сверяем шаблон ответа
        softAssertions.assertThat("Да, обязательно. Всем самокатов! И Москве, и Московской области.")
                .isEqualTo(mainPage.answerOnQuestion(8));
        softAssertions.assertAll();

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
