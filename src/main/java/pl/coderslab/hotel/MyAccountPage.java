package pl.coderslab.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String myPage() {

        WebElement successAlert = this.driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]"));
        return successAlert.getText();
    }

    public void backToMainPage() {
        WebElement homeButton = this.driver.findElement(By.id("header_logo"));
        homeButton.click();
    }
}