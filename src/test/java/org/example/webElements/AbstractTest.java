package org.example.webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {


    private static Logger logger = LoggerFactory.getLogger(AbstractTest.class);
    private static WebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        logger.info("tests started");

    }

    @BeforeEach
    void goTo() throws InterruptedException {
        driver.get("https://www.codewars.com/");
        driver.manage().deleteCookieNamed("WebSait have cookies");
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://www.codewars.com/"), "The site is not available.");

        //переход к форме авторизации
        WebElement buttonWithLogin = getDriver().findElement(By.xpath("//*[@id='login-btn']"));
        buttonWithLogin.click();
        //login (Базовая авторизация пользователя)
        LoginFormsPage userLogin = new LoginFormsPage(getDriver());
        userLogin.userLoginPassword("ivsOrigin@gmail.com", "162018Bobbi");

        Thread.sleep(3000);

        String itemName = getDriver().findElement(By.xpath("//*[@id='header_profile_link']/div[1]/img")).getText();
        Assertions.assertEquals(true, itemName.contains(getDriver().findElement(By.xpath("//*[@id='header_profile_link']/div[1]/img")).getText()));

        Thread.sleep(3000);
    }

    @AfterEach
    public void checkBrowser() {
        List<LogEntry> allLogRows = getDriver().manage().logs().get(LogType.BROWSER).getAll();
        if (!allLogRows.isEmpty()){
            if (allLogRows.size() > 0 ) {
                allLogRows.forEach(logEntry -> {
                    System.out.println(logEntry.getMessage());
                });
            }
        }
    }

    @AfterAll
    static void close() {
        logger.info("tests completed.");
        //if (driver !=null) driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
