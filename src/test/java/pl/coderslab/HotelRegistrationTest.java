package pl.coderslab;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.hotel.*;

import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class HotelRegistrationTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        this.driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @After
    public void tearDown(){
        this.driver.quit();
    }


    @Test
    public void isPossibleToRegisterNewUser() {
        String email = "test@test" + new Random().nextInt(1000000) + ".com";
        WebElement signInButton = this.driver.findElement(By.className("user_login"));
        signInButton.click();
        WebElement emailAddressInput = this.driver.findElement(By.className("is_required"));
        emailAddressInput.clear();
        emailAddressInput.sendKeys(email);
        this.driver.findElement(By.id("SubmitCreate")).click();

        WebElement customerNameInput = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[1]/div[2]/input"));
        customerNameInput.sendKeys("Jan");
        WebElement customerLastNameInput = this.driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        customerLastNameInput.sendKeys("Sobieski");
        WebElement passwordInput = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[1]/div[5]/input"));
        passwordInput.sendKeys("12345");
        WebElement submitButton = this.driver.findElement(By.xpath("//*[@id=\"submitAccount\"]"));
        submitButton.click();
        String expectedSuccessAlertText = "Your account has been created.";

        WebElement successAlert = this.driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]"));

        assertEquals(expectedSuccessAlertText, successAlert.getText()); // Sprawdzamy czy rzeczywiscie utworzylo nowego uzytkownika
    }

    @Test
    public void isPossibleToRegisterNewUserPOM() {
        String email = "test@test" + new Random().nextInt(1000000) + ".com";

        MainPage mainPage = new MainPage(this.driver);
        mainPage.goToLoginPage();

        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.createAccountWith(email);

        RegisterPage registerPage = new RegisterPage(this.driver);
        registerPage.registerAccountWith("Jan", "Sobieski", "12345");

        MyAccountPage myAccountPage = new MyAccountPage(this.driver);

        String expectedSuccessAlertText = "Your account has been created.";

        assertEquals(expectedSuccessAlertText, myAccountPage.myPage()); // Sprawdzamy czy rzeczywiscie utworzylo nowego uzytkownika
    }

    @Test
    public void isPossibleToSearchHotelsByName() {

        MainPage mainPage = new MainPage(this.driver);
        mainPage.goToLoginPage();

        LoginPage loginUser = new LoginPage(this.driver);
        loginUser.loginAccountWith("test121@test.pl", "111111");

        MyAccountPage backToMainPage = new MyAccountPage(this.driver);
        backToMainPage.backToMainPage();

        mainPage.searchByHotelName("06-04-2024", "17-04-2024");

        SearchResultPage bookHotel = new SearchResultPage(this.driver);
        bookHotel.ChooseHotel();
        bookHotel.ProceedToCheckout();

        CheckOutPage checkoutPage = new CheckOutPage(this.driver);
        checkoutPage.acceptTerms();

        OrderSummaryPage orderSummaryPage = new OrderSummaryPage(this.driver);
        orderSummaryPage.confirmOrder();
    }
}