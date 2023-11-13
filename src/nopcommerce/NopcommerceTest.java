package nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class NopcommerceTest {

    static String browser = "Chrome";
    static String baseurl = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //Setup multi browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }else {
            System.out.println("Wrong browser name");
        }
        //Open the url into browser
        driver.get(baseurl);
        Thread.sleep(4000);

        //Maximise the browser
        driver.manage().window().maximize();

        //We give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Get the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //get the current url
        System.out.println("The current url : "+ driver.getCurrentUrl());

        //Get the source code
        System.out.println(driver.getPageSource());

        //Navigate to url
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(loginUrl);

        //Print the current url
        System.out.println("The current url : " + driver.getCurrentUrl());

        //Navigate back to the home page
        driver.navigate().back();

        //Navigate to the login page
        driver.navigate().to(loginUrl);

        //print the current url
        System.out.println("The current url : "+ driver.getCurrentUrl());

        //refresh the page
        driver.navigate().refresh();

        //Enter email to email field
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("hello");

        Thread.sleep(1000);
        //Enter the password to the password field
        WebElement pwd = driver.findElement(By.id("Password"));
        pwd.sendKeys("hello123");
        Thread.sleep(1000);
        //Click on login button
        WebElement loginButton = driver.findElement(By.linkText("Log in"));
        loginButton.click();
        Thread.sleep(1000);
        //Close the browser
        driver.quit();
    }
}
