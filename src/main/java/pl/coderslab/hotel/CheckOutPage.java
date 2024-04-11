package pl.coderslab.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {

    private WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptTerms() {

        WebElement agree = this.driver.findElement(By.id("cgv"));
        agree.click();

        WebElement paymentsMethod = this.driver.findElement(By.className("bankwire"));
        paymentsMethod.click();
    }
}