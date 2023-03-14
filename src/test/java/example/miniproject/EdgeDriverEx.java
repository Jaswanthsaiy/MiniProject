package example.miniproject;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class EdgeDriverEx {
    @Test
    public void test() {
        //WebDriver driver;
        System.out.println("welcome");
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        System.setProperty("webdriver.edge.driver","C:\\Program Files\\webdriver1\\msedgedriver.exe");
        WebDriver driver =new EdgeDriver();
        driver.get("https://www.github.com/login");
        System.out.println(driver.getTitle());
        driver.findElement(By.id("login_field")).sendKeys("2000031124");
        highlight(driver,driver.findElement(By.id("login_field")));
        driver.findElement(By.name("password")).sendKeys("welcome");
        highlight(driver,driver.findElement(By.name("password")));
        driver.findElement(By.className("header-logo"));
        highlight(driver,driver.findElement(By.className("header-logo")));
        //driver.findElement(By.linkText("Forgot password?")).click();
        highlight(driver,driver.findElement(By.linkText("Forgot password?")));
        //driver.findElement(By.partialLinkText("Create an account")).click();
        driver.findElement(By.tagName("h1"));
        highlight(driver,driver.findElement(By.tagName("h1")));
        driver.findElement(By.cssSelector("#login_field")).sendKeys("@kluniversity.in");
        highlight(driver, driver.findElement(By.cssSelector("#login_field")));

    }
    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
}