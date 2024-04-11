
package pl.coderslab.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage() {
        WebElement signInButton = this.driver.findElement(By.className("user_login"));
        signInButton.click();
    }

    public void searchByHotelName(String checkIn, String checkout) {
        WebElement openDropDownMenu = this.driver.findElement(By.id("hotel_cat_name"));
        openDropDownMenu.click();
        WebElement selectHotel = this.driver.findElement(By.className("hotel_name"));
        selectHotel.click();

        WebElement checkInInput = this.driver.findElement(By.id("check_in_time"));
        checkInInput.sendKeys(checkIn);

        WebElement checkOutInput = this.driver.findElement(By.id("check_out_time"));
        checkOutInput.sendKeys(checkout);

        WebElement searchButton = this.driver.findElement(By.name("search_room_submit"));
        searchButton.click();
    }


}
