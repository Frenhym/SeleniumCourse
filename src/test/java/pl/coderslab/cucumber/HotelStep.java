package pl.coderslab.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HotelStep {
    private WebDriver driver;

    @Given("Użytkownik jest na stronie sklepu")
    public void openBroswerShop() {
        this.driver = new ChromeDriver();
        this.driver.get("https://mystore-testlab.coderslab.pl/");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @When("Użytkownik loguje się mailem <word> i hasłem <word>")
    public void loginAccountWith(String mail, String password) {
        WebElement signInButton = this.driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a"));
        signInButton.click();
        WebElement emailAddressInput = this.driver.findElement(By.xpath("//*[@id=\"field-email\"]"));
        emailAddressInput.clear();
        emailAddressInput.sendKeys(mail);
        WebElement passwordInput = this.driver.findElement(By.xpath("//*[@id=\"field-password\"]"));
        passwordInput.sendKeys(password);
        WebElement submitButton = this.driver.findElement(By.xpath("//*[@id=\"submit-login\"]"));
        signInButton.click();
    }

    @And("Zamknięcie przeglądarki")
    public void quitBrowser() {
        this.driver.quit();
    }
}
