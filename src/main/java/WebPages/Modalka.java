package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Modalka {
    //модалка с номером заказа
    public By orderStatus = By.xpath("//div[text()='Заказ оформлен']");
    private WebDriver driver;

    public Modalka(WebDriver driver) {
        this.driver = driver;
    }

    //проверка появления уведомления о том, что заказ оформлен
    public void checkOrderStatus() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderStatus)));
    }
}
