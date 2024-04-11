package pl.coderslab.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {

    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ChooseHotel() {

        WebElement bookNowButton = this.driver.findElement(By.className("ajax_add_to_cart_button"));
        bookNowButton.click();
    }

    public void ProceedToCheckout() {

        WebElement proceedButton = this.driver.findElement(By.className("button-medium"));
        proceedButton.click();
    }
}