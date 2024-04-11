package pl.coderslab.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class DuckDuckGoStep {

    private WebDriver driver;

    @Given("an open browser with duckduckgo.com")
    public void openBrowserWithDuckDuckGo() {
        this.driver = new ChromeDriver();
        this.driver.get("https://duckduckgo.com");
    }

    @When("user search for {word}")
    public void searchForKeyword(String keyword) {
        // Znajdz element na zaladowanej stronie.
        WebElement searchField = this.driver.findElement(By.name("q"));
        // Dla pewnosci wyczysc pole wyszukiwania
        searchField.clear();
        // Wpisz w pole wyszukiwania dana fraze
        searchField.sendKeys(keyword);
        // Kliknij enter, zatwierdz wyszukiwanie
        searchField.submit();
    }

    @Then("the first result should contain {word}")
    public void firstResultContains(String phrase) {
        WebElement firstResult = this.driver.findElement(By.xpath("//*[@id=\"r1-0\"]/div[1]/div/a"));
        assertTrue(firstResult.getText().contains(phrase));
    }

    @And("quit browser")
    public void quitBrowser() {
        this.driver.quit();
    }

}