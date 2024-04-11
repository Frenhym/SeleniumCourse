package pl.coderslab.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerAccountWith(String name, String lastName, String password) {

        WebElement customerNameInput = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[1]/div[2]/input"));
        customerNameInput.sendKeys(name);
        WebElement customerLastNameInput = this.driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        customerLastNameInput.sendKeys(lastName);
        WebElement passwordInput = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[1]/div[5]/input"));
        passwordInput.sendKeys(password);
        WebElement submitButton = this.driver.findElement(By.xpath("//*[@id=\"submitAccount\"]"));
        submitButton.click();
    }
}