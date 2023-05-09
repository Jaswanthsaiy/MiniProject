package org.example;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MenuDrivenProgram {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Choose an option:");
            System.out.println("1. Open browser");
            System.out.println("2. Open URL");
            System.out.println("3. Open browser with credentials");
            System.out.println("4. Open URL with invalid credentials");
            System.out.println("5. Implement static locators");
            System.out.println("6. Implement dynamic CSS Selector");
            System.out.println("7. Implement dynamic XPath");
            System.out.println("8. Implement HTML controls");
            System.out.println("9. Implement alerts");
            System.out.println("0. Exit");

            choice = scanner.nextLine();

            switch(choice) {

                case "1":
                    openBrowser();
                    break;

                case "2":
                    openUrl();
                    break;

                case "3":
                    openBrowserWithCredentials();
                    break;

                case "4":
                    openUrlWithInvalidCredentials();
                    break;

                case "5":
                    implementStaticLocators();
                    break;

                case "6":
                    implementDynamicCssSelector();
                    break;

                case "7":
                    implementDynamicXPath();
                    break;

                case "8":
                    implementHtmlControls();
                    break;

                case "9":
                    implementAlerts();
                    break;

                case "0":
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");

            }

        } while(!choice.equals("0"));

        scanner.close();
    }

    public static void openBrowser() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    public static void openUrl() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the URL:");
        String url = scanner.nextLine();
        scanner.close();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

    }

    public static void openBrowserWithCredentials() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the username:");
        String username = scanner.nextLine();
        System.out.println("Enter the password:");
        String password = scanner.nextLine();
        scanner.close();

        if(username.equals("admin") && password.equals("password")) {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else {
            System.out.println("Invalid credentials. Browser cannot be opened.");
        }

    }

    public static void openUrlWithInvalidCredentials() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the URL:");
        String url = scanner.nextLine();
        System.out.println("Enter the username:");
        String username = scanner.nextLine();
        System.out.println("Enter the password:");
        String password = scanner.nextLine();
        scanner.close();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='error-message']"));
        if(errorMessage.getText().equals("Invalid credentials")) {
            System.out.println("Invalid credentials. Login failed.");
        } else {
            System.out.println("Login successful.");
        }

        driver.quit();

    }

    public static void implementStaticLocators() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Java programming");

        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();

        WebElement resultsLink = driver.findElement(By.xpath("//h3[contains(text(),'Java Programming Tutorial - Tutorialspoint')]"));
        resultsLink.click();

        driver.quit();

    }

    public static void implementDynamicCssSelector() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));
        searchBox.sendKeys("Selenium webdriver");

        WebElement searchButton = driver.findElement(By.cssSelector("input[name='btnK']"));
        searchButton.click();

        WebElement resultsLink = driver.findElement(By.cssSelector("h3[class='LC20lb DKV0Md']"));
        resultsLink.click();

        driver.quit();

    }

    public static void implementDynamicXPath() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("TestNG framework");

        WebElement searchButton = driver.findElement(By.xpath("//input[@name='btnK']"));
        searchButton.click();

        WebElement resultsLink = driver.findElement(By.xpath("//h3[text()='TestNG - Welcome']"));
        resultsLink.click();

        driver.quit();

    }

    public static void implementHtmlControls() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

        WebElement singleDropdown = driver.findElement(By.id("select-demo"));
        singleDropdown.sendKeys("Friday");

        WebElement multiDropdown = driver.findElement(By.id("multi-select"));
        multiDropdown.sendKeys("Ohio");
        multiDropdown.sendKeys("Texas");
        multiDropdown.sendKeys("Washington");

        WebElement radioMale = driver.findElement(By.xpath("//input[@name='optradio'][@value='Male']"));
        radioMale.click();

        WebElement radioFemale = driver.findElement(By.xpath("//input[@name='optradio'][@value='Female']"));
        radioFemale.click();

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        checkbox1.click();

        WebElement checkbox2 = driver.findElement(By.xpath("//input[@value='Check All']"));
        checkbox2.click();

        driver.quit();

    }

    public static void implementAlerts() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");

        WebElement simpleAlertButton = driver.findElement(By.xpath("//button[contains(text(),'Click me!')]"));
        simpleAlertButton.click();
        driver.switchTo().alert().accept();

        WebElement confirmAlertButton = driver.findElement(By.xpath("//button[contains(text(),'Click me!')]"));
        confirmAlertButton.click();
        driver.switchTo().alert().dismiss();

        WebElement promptAlertButton = driver.findElement(By.xpath("//button[contains(text(),'Click for Prompt Box')]"));
        promptAlertButton.click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Hello, ChatGPT!");
        promptAlert.accept();
        driver.quit();
    }


