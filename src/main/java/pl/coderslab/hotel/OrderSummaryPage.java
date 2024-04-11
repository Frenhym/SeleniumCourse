
package pl.coderslab.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSummaryPage {

    private WebDriver driver;

    public OrderSummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmOrder() {

        WebElement confirmButton = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/form/p/button"));
        confirmButton.click();
    }
}
