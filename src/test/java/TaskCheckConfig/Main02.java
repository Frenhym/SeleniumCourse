package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main02 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        driver.findElement(By.name("hotel_location")).sendKeys("Warsaw");
        driver.findElement(By.name("search_room_submit")).submit();
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.name("submitNewsletter"));
        driver.quit();
    }
}





