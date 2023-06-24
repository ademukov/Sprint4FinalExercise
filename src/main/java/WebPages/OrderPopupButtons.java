package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrderPopupButtons {

    private WebDriver driver;
    //кнопка Нет
    private By buttonNo = By.xpath("//button[text()='Нет']");
    //кнопка Да
    private By buttonYes = By.xpath("//button[text()='Да']");

    public OrderPopupButtons(WebDriver driver) {

        this.driver = driver;
    }

    //нажать кнопку Да
    public void clickYesButton() {
        driver.findElement(buttonYes).click();
    }
}