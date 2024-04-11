package pl.coderslab.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createAccountWith(String email) {
        WebElement emailAddressInput = this.driver.findElement(By.className("is_required"));
        emailAddressInput.clear();
        emailAddressInput.sendKeys(email);
        this.driver.findElement(By.id("SubmitCreate")).click();
    }

    public void loginAccountWith(String email, String password) {

        WebElement emailInput = this.driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement passwordInput = this.driver.findElement(By.id("passwd"));
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement signInButton = this.driver.findElement(By.id("SubmitLogin"));
        signInButton.click();
    }
}