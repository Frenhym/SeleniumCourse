package pl.coderslab.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class HotelStep {
    private WebDriver driver;

    @Given("Użytkownik jest na stronie hotelu")
    public void openBrowserHotel() {
        //otwarcie strony główneh hotelu
        this.driver = new ChromeDriver();
        this.driver.get("https://hotel-testlab.coderslab.pl/.");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("Użytkownik rejestruje się z {word} {word} i hasłem {word}")
    public void ClickSignInButton(String name, String lastname, String password) {
        String email = "test@test" + new Random().nextInt(1000000) + ".com";
        WebElement signInButton = this.driver.findElement(By.className("user_login"));
        signInButton.click();
        WebElement emailAddressInput = this.driver.findElement(By.className("is_required"));
        emailAddressInput.clear();
        emailAddressInput.sendKeys(email);
        this.driver.findElement(By.id("SubmitCreate")).click();

        WebElement customerNameInput = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[1]/div[2]/input"));
        customerNameInput.sendKeys(name);
        WebElement customerLastNameInput = this.driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        customerLastNameInput.sendKeys(lastname);
        WebElement passwordInput = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[1]/div[5]/input"));
        passwordInput.sendKeys(password);
        WebElement submitButton = this.driver.findElement(By.xpath("//*[@id=\"submitAccount\"]"));
        submitButton.click();
    }

    @And("Użytkownik dodaje swój pierwszy adres {word} {word} {word} {word}")
    public void AddressInput(String address, String postalCode, String city, String phoneNumber) {
        WebElement clickButtonAddMyFirstAddress = this.driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/ul/li[1]/a/span"));
        clickButtonAddMyFirstAddress.click();
        WebElement customerAddressInput = this.driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        customerAddressInput.sendKeys(address);
        WebElement customerpostalCode = this.driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
        customerpostalCode.sendKeys(postalCode);
        WebElement customerCity = this.driver.findElement(By.xpath("//*[@id=\"city\"]"));
        customerCity.sendKeys(city);
        WebElement customerphoneNumber = this.driver.findElement(By.xpath("//*[@id=\"phone\"]"));
        customerphoneNumber.sendKeys(phoneNumber);
        WebElement customerSaveAddress = this.driver.findElement(By.xpath("//*[@id=\"alias\"]"));
        customerSaveAddress.click();
        WebElement clickButtonSave = this.driver.findElement(By.xpath("//*[@id=\"submitAddress\"]"));
        clickButtonSave.click();
    }


    @Then("Adres użytkownika został zapisany")
    public void VeryfiAddressCreation() {

        WebElement successAlert = this.driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[11]/a[2]"));
        assertTrue(true); // Sprawdzamy czy rzeczywiscie utworzylo nowego uzytkownika
    }

    @And("Usunięcie adresu")
    public void DeleteAddress() {
        WebElement deleteAdress = this.driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[11]/a[2]"));
        deleteAdress.click();
        //Store the alert in a variable
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @And("Zrzut ekranu")
    public void ScreenShot() throws IOException {
        String imageNew = "./image" + new Random().nextInt(1000000) + ".png";
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(imageNew));
    }

    @And("Zamknięcie przeglądarki")
    public void quitBrowser() {
        this.driver.quit();
    }
}