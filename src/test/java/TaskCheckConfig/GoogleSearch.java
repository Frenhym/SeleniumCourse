package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        driver.findElement(By.id("L2AGLb")).click();
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("Kapibara");
        element.submit();
        driver.quit();
    }
}
