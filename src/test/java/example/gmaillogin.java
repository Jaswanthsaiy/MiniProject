package example;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class gmaillogin {
    @Test
    public void test() {
        WebDriver driver;
        System.out.println("welcome");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S-637225323%3A1675651987422064&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&rip=1&sacu=1&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AWnogHdh2kPXl-NdnuVICEvy2QI_lqww9pqlV01YJtvtfM2ARebhbN6-esdc7yoj31u278_XzVwPGw");
        System.out.println(driver.getTitle());
        driver.findElement(By.id("identifierId")).sendKeys("jsai2099@gmail.com");
        highlight(driver,driver.findElement(By.id("identifierId")));
        //driver.findElement(By.name("password")).sendKeys("welcome");
        //highlight(driver,driver.findElement(By.name("password")));
       // driver.findElement(By.name("Cuz2Ue")).click();
        //highlight(driver,driver.findElement(By.className("Cuz2Ue")));
        //driver.findElement(By.linkText("Forgot email?")).click();
        //highlight(driver,driver.findElement(By.linkText("Forgot email?")));
        //driver.findElement(By.partialLinkText("Create an account")).click();
        //driver.findElement(By.tagName("h1"));
        //highlight(driver,driver.findElement(By.tagName("h1")));


    }
    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
}