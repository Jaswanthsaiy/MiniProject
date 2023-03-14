package example;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class GithubLoginVerification {
    @Test
    public void test() {
        WebDriver driver;
        System.out.println("welcome");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.github.com/login");
        System.out.println(driver.getTitle());
        driver.findElement(By.cssSelector("input[id='login_field']")).sendKeys("2000031124@kluniversity.in");
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("Wore943bout09");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        System.out.println(driver.findElement(By.className("js-flash-alert")).getText());
    }
}
