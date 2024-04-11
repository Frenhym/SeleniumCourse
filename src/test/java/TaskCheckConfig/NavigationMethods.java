package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        driver.get("https://www.coderslab.pl/pl");
        driver.navigate().back();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
    }
}



