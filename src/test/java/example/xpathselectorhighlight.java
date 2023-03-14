package example;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class xpathselectorhighlight {
    @Test
    public void test(){
        WebDriver driver;
        System.out.println("welcome");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.github.com/login");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//input[@id='login_field']")).sendKeys("2000031124@kluniversity.in");
        highlight(driver,driver.findElement(By.xpath("//input[@id='login_field']")));
    }
    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
}
